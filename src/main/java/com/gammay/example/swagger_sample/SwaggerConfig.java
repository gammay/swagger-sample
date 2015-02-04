package com.gammay.example.swagger_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfig {

	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * Required to autowire SpringSwaggerConfig
	 */
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	/**
	 * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
	 * framework - allowing for multiple swagger groups i.e. same code base
	 * multiple swagger resource listings.
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
        .apiInfo(apiInfo());
		
		/*
		List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
		Option<String> option = Option.apply(null);
		responseMessages.add(new ResponseMessage(200, "Success", option));
		responseMessages.add(new ResponseMessage(400, "Bad Request", option));
		responseMessages.add(new ResponseMessage(401, "Unauthorized (Not logged in or invalid session or resource cannot be accessed)", option));
		responseMessages.add(new ResponseMessage(404, "Requested resource is not found", option));
		responseMessages.add(new ResponseMessage(500, "Internal Server Error", option));
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo())
				.globalResponseMessage(RequestMethod.GET, responseMessages)
				.globalResponseMessage(RequestMethod.POST, responseMessages)
				.globalResponseMessage(RequestMethod.PUT, responseMessages)
				.globalResponseMessage(RequestMethod.DELETE, responseMessages);
		*/
	}

	 private ApiInfo apiInfo() {
	      ApiInfo apiInfo = new ApiInfo(
	              "My Contacts Service",
	              "This is my sample contacts service that shows how to use Swagger",
	              "API terms of service",
	              "Contact Email",
	              "Licence Type",
	              "License URL"
	        );
	      return apiInfo;
	    }
}
