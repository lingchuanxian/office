package cn.fjlcx.office;

/**
 * Created by lcx on 2017/6/27.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
		* Restful API 访问路径:
		* http://IP:port/{context-path}/swagger-ui.html
		* eg:http://localhost:8080/jd-config-web/swagger-ui.html
		*/
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"cn.fjlcx.office.controller.webservice"})
@Configuration
public class RestApiConfig extends WebMvcConfigurationSupport {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("cn.fjlcx.office.controller.webservice"))
				.paths(PathSelectors.any())
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring MVC中使用Swagger2构建RESTful APIs")
				.termsOfServiceUrl("http://github.com/smlcx")
				.contact("story's")
				.version("1.1")
				.build();
	}
}

