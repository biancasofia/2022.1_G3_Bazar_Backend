package com.fga.bazar.configurations.documentacao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String DIRETORIO_BASE = "com.fga.bazar.controllers";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(DIRETORIO_BASE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API do projeto desenvolvido pelo Grupo 03",
                "Esta API é utilizada em um Bazar Online desenvolvido na matéria de " +
                        "Arquitetura e Desenho de Software da Universidade de Brasília, Campus do Gama",
                "Versão 1.0",
                "https://unbarqdsw2022-1.github.io/2022.1_G3_Bazar/#/",
                new Contact("Grupo 03", "https://unbarqdsw2022-1.github.io/2022.1_G3_Bazar/#/", "silvadouglas328@gmail.com"),
                "Permitido uso para estudantes",
                "https://unbarqdsw2022-1.github.io/2022.1_G3_Bazar/#/",
                Collections.emptyList() // Vendor Extensions
        );
    }

}
