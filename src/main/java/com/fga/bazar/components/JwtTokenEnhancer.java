package com.fga.bazar.components;

import com.fga.bazar.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    private final Logger LOG = LoggerFactory.getLogger(JwtTokenEnhancer.class);

    @Autowired
    private UsuarioRepository userRepository;


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
                                     OAuth2Authentication authentication) {
        var nomeDeUsuario = authentication.getName();
        var usuario = userRepository.findByEmail(nomeDeUsuario);

        if (usuario == null) {
            LOG.error("Nome de usuário não encontrado! Usuário: " + usuario);
            throw new UsernameNotFoundException("Usuário não encontrado! Nome de usuário: " + nomeDeUsuario);
        }

        var informacaoAdicionalAoToken = new HashMap<String, Object>();

        informacaoAdicionalAoToken.put("usuarioId", usuario.getId());
        informacaoAdicionalAoToken.put("nomeDeUsuario", usuario.getEmail());

        var token = (DefaultOAuth2AccessToken) accessToken;

        token.setAdditionalInformation(informacaoAdicionalAoToken);

        return accessToken;
    }
}
