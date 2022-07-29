package com.fga.bazar.services;

import com.fga.bazar.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private Logger LOG = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = usuarioRepository.findByEmail(username);

        if (usuario == null) {
            LOG.error("Usuário não encontrado! Usuário: " + username);
            throw new UsernameNotFoundException("Usuário não encontrado! Usuário: " + username);
        }

        LOG.info("Usuário encontrado! Usuário: " + username);

        return usuario;
    }

}
