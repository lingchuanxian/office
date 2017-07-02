package cn.fjlcx.office;

/**
 * Created by lcx on 2017/6/27.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
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
@Configuration
@EnableWebMvc
@EnableSwagger2
public class RestApiConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("对外开放接口API 文档")
				.description("HTTP对外开放接口")
				.version("1.0.0")
				.termsOfServiceUrl("http://xxx.xxx.com")
				.license("LICENSE")
				.licenseUrl("http://xxx.xxx.com")
				.build();
	}

}

