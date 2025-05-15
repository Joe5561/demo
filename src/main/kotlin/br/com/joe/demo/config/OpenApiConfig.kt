package br.com.joe.demo.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Restful with Kotlin and Spring boot")
                    .version("v1")
                    .description("API developed for registration testing")
                    .termsOfService("https://pt.wikipedia.org/wiki/Kotlin")
                    .license(
                        License().name("Apache 2.0")
                            .url("https://pt.wikipedia.org/wiki/Kotlin")
                    )
            )
    }

}