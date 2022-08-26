package com.fga.bazar.configurations.seguranca;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class CodificadorConfiguration {

    @Value("${jwt.secret}")
    private String segredoJwt;

    @Bean
    public BCryptPasswordEncoder codificadorDeSenha() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAccessTokenConverter conversorDeToken() {
        var conversorToken = new JwtAccessTokenConverter();
        conversorToken.setSigningKey(segredoJwt);

        return conversorToken;
    }

    @Bean
    public JwtTokenStore armazenadorDeToken() {
        return new JwtTokenStore(conversorDeToken());
    }

}
