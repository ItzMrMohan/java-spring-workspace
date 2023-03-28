package edu.aspire.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootConfiguration
//@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages = {"edu.aspire.controllers"})
public class AspireWebConfig {
	/*@Bean
	public HandlerMapping handlerMapping(){ //autoconfigured by spring boot
		return new DefaultAnnotationHandlerMapping();
	}*/
	
	/*@Bean
	public ViewResolver viewResolver(){ //auto configured by spring boot
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(InternalResourceView.class);
		return resolver;
	}*/
}
