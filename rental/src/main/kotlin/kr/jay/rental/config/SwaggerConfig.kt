package kr.jay.rental.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

/**
 * SwaggerConfig
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/2/23
 */

@Configuration
class SwaggerConfig {

    @Bean
    fun api() =
        Docket(DocumentationType.OAS_30)
            .useDefaultResponseMessages(true)
            .select()
            .apis(RequestHandlerSelectors.basePackage("kr.jay.rental"))
            .paths(PathSelectors.any())
            .build()!!

}