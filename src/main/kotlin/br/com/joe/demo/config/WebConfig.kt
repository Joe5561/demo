package br.com.joe.demo.config

import br.com.joe.demo.serialization.converter.YamlJackson2HttpMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
class WebConfig : WebMvcConfigurer {

    private val MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml")

    @Value("\${cors.originPatterns:default}")
    private val corsOriginPatterns: String = ""

    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(YamlJackson2HttpMessageConverter())
    }

    override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer) {
        configurer.favorParameter(false)
            .ignoreAcceptHeader(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json", MediaType.APPLICATION_JSON)
            .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML)
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        val allowerOrigins = corsOriginPatterns.split(",").toTypedArray()
        registry.addMapping("/**")
            .allowedMethods("*")
            .allowedOrigins(*allowerOrigins)
            .allowCredentials(true)
    }
}