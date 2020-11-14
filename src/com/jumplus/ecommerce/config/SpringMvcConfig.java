package com.jumplus.ecommerce.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.jumplus.ecommerce.dao.ItemDAO;
import com.jumplus.ecommerce.dao.UserDAO;
import com.jumplus.ecommerce.daoimp.ItemDAOimp;
import com.jumplus.ecommerce.daoimp.UserDAOimp;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jumplus.ecommerce")
public class SpringMvcConfig implements WebMvcConfigurer{
	

	@Bean
	public ViewResolver getViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);	
		return resolver;
		
	}
	
	@Bean
	public UserDAO getUserDAO() {
		return new UserDAOimp();
	}
	
	@Bean
	public ItemDAO getItemDAO() {
		return new ItemDAOimp();
	}

}
