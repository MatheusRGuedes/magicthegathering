package com.zappts.magicthegathering.api.config.swagger;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/*
 * Classe de configuração que o spring vai gerenciar para
 * Instanciar um bean de configuração do springfox (pega a API e gera o modelo Swagger)
 * 
 * Docket   --> objeto que configura tudo do swagger
 * select() --> inicia o build do seletor 
 * apis()	--> Quais constrollers irão ser usados
 * paths()	--> Quais recursos serão mostrados dos controllers
 * 
 * link: 	   http://localhost:8080/api/swagger-ui/index.html
 * referencia: https://springfox.github.io/springfox/docs/current/#background
 * */

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.zappts.magicthegathering.api.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				.tags(new Tag("Jogador", "All resources relating to jogador."),
						new Tag("Lista Jogador", "All resources relating to lista."),
						new Tag("Carta", "All resources relating to carta."));
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("Swagger - Magic The Gathering", 
				"This is a simple demonstration of using the Magic The Gathering API for manage your carts.", 
				"1.0", "", ApiInfo.DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html", 
				new ArrayList<>());
	}
}
