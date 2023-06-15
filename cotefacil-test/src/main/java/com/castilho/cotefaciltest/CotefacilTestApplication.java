package com.castilho.cotefaciltest;

import com.castilho.cotefaciltest.services.SwService;
import com.sun.faces.config.ConfigureListener;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletRequestListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import javax.faces.webapp.FacesServlet;
import java.util.EventListener;


@Configuration
@Profile("test")
@SpringBootApplication
@SpringBootConfiguration
public class CotefacilTestApplication{

	@Autowired
	private SwService service;

	public static void main(String[] args) {
		SpringApplication.run(CotefacilTestApplication.class, args);
	}

	@PostConstruct
	public void init(){
		if(service.getCount() == 0){
			service.init();
		}
	}

	/*
	@Bean
	public ServletRegistrationBean facesServletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean<>();
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("*.jar");
		return registrationBean;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer(){
		return servletContext -> {
			servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
			servletContext.setInitParameter("primefaces.THEME", "redmond");
		};
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	 */
}
