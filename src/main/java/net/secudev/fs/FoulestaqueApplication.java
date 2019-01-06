package net.secudev.fs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@EnableSwagger2
public class FoulestaqueApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FoulestaqueApplication.class, args);
	}


	
	//SWAGGER permet de générer de la doc pour l'API REST
	
	//http://localhost:8080/swagger-ui.html#/	
		@Bean
		public Docket swaggerEmployeeApi() {
		    return new Docket(DocumentationType.SWAGGER_2)
		        .select()
		            .apis(RequestHandlerSelectors.basePackage("net.secudev.fs.interfaces.controller"))
		            .paths(PathSelectors.any())
		        .build()
		        .apiInfo(new ApiInfoBuilder().version("1.0").title("API").description("Documentation API v1.0").build());
		}

}

