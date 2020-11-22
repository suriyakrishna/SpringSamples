package com.kishan.springpractice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact CONTACT = new Contact("Suriya Krishna Mohan", "https://github.com/suriyakrishna",
            "suriya.kishan@live.com");
    private static final ApiInfo DEFAULT_API = new ApiInfo("Spring Learning", "API for the purpose of learning spring boot with MongoDB and MySql integration", "1.0", "urn:tos", CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kishan.springpractice"))
                .build();
    }
}
