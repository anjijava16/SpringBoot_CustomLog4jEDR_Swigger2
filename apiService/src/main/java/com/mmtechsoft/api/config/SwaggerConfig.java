package com.mmtechsoft.api.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@EnableAutoConfiguration	
public class SwaggerConfig {

	
//	@Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.mmtechsoft.smscinbound"))
//                .paths(regex("/user.*"))
//                .build()
//                .apiInfo(metaInfo());
//    }


	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build();
	    }
	 
	 	
	private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo("-2018 MicroService Portal",
                "Hackthron-2018 API Service",
                "1.0",
                "Terms of Service",
                new Contact("Hackthron-2018", "https://www.mmtechsoft.com",
                        "anjaiahspr@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

        return apiInfo;
    }
}