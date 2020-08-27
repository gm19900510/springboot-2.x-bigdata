package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/").select()
				.apis(RequestHandlerSelectors.basePackage("com.example.controller")).paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfoBuilder().title("SpringBoot 2.x 整合Hive、Hbase").description("API 接口测试平台")
						.version("1.0")
						.contact(new Contact("高明", "https://gaoming.blog.csdn.net/", "1025304567@qq.com"))// 作者
						.license("The Apache License, Version 2.0")
						.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").build());
	}
}
