package configuration;

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
public class SwaggerConfiguration {

	//Builder Pattern
	@Bean
	public Docket devDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("controller"))
				.build()
				.apiInfo(apiInfo());
	}
	
	ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Inventory API")
                .description("The first version of Inventory RESTful API")
                .version("1.0.0")
                .build();
    }

}
