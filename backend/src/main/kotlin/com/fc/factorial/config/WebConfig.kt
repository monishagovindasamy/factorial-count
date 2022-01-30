package com.fc.factorial.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    //CORS mapping to allow only specified origins to allow calls
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200")
            .allowedHeaders("*")
            .allowedMethods("*")
            .maxAge(1000L)
            .allowCredentials(true)
    }

}
