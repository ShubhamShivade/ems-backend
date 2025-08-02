package com.shubham.ems.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiDocumentationConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My Awesome API")
                        .version("1.0.0")
                        .description("This is the backend for the full-stack blog application.")
                        .termsOfService("https://example.com/terms")
                        .contact(new Contact()
                                .name("Shubham Shivade")
                                .email("shubham@shivade.com")
                                .url("https://github.com/shubhamshivade"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}