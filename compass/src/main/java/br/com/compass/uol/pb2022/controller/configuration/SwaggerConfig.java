package br.com.compass.uol.pb2022.controller.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket configuration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.compass"))
                .build()
                .apiInfo(informationApi());
    }

    private ApiInfo informationApi() {
        return new ApiInfoBuilder()
                .title("Assosiates & Parties")
                .description("Membership and Party registration system")
                .version("1.0.0")
                .build();
    }
}
