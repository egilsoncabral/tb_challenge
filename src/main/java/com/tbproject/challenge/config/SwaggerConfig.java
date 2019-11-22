package com.tbproject.challenge.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger Configurator
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bus GPS API")
                .description("A web service that exposes Vehicle (Bus), Fleet (Operator) and Activity (Stop) data, for a given time frame")
                .license("")
                .licenseUrl("http://unlicense.org")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("","", ""))
                .build();
    }

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tbproject.challenge.controller"))
                //.paths(PathSelectors.ant("/api/**"))
                .build()
                .useDefaultResponseMessages(false)
                .produces(Sets.newHashSet(APPLICATION_JSON_VALUE))
                .consumes(Sets.newHashSet(APPLICATION_JSON_VALUE))
                .apiInfo(apiInfo());
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}