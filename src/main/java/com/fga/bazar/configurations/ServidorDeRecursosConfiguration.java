package com.fga.bazar.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.List;

@Configuration
@EnableResourceServer
public class ServidorDeRecursosConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment env;

    private JwtTokenStore armazenadorDeToken;

    private final String[] URIS_PUBLICAS = {
        "/oauth/token",
        "/h2-console/**",
    };

    private final String[] URI_GET_PUBLICAS = {};

    private final String[] URI_POST_PUBLICAS = {};

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(armazenadorDeToken);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if (List.of(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
                .antMatchers(URIS_PUBLICAS).permitAll()
                .antMatchers(HttpMethod.GET, URI_GET_PUBLICAS).permitAll()
                .antMatchers(HttpMethod.POST, URI_POST_PUBLICAS).permitAll()
                .anyRequest().authenticated();
    }
}
