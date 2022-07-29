package com.fga.bazar.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class CodificadorConfiguration {

    private final String SEGREDO_JWT;

    public CodificadorConfiguration(@Value("${jwt.secret}") final String segredoJwt) {
        this.SEGREDO_JWT = segredoJwt;
    }

    @Bean
    public BCryptPasswordEncoder codificadorDeSenha() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAccessTokenConverter conversorDeToken() {
        var conversorToken = new JwtAccessTokenConverter();
        conversorToken.setSigningKey(SEGREDO_JWT);

        return conversorToken;
    }

    @Bean
    public JwtTokenStore armazenadorDeToken() {
        return new JwtTokenStore(conversorDeToken());
    }

}
