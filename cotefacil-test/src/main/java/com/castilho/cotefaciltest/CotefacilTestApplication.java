package com.castilho.cotefaciltest;

import com.castilho.cotefaciltest.services.SwService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Configuration
@Profile("test")
@SpringBootApplication
public class CotefacilTestApplication {

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

}
