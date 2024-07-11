package com.aspacelife.server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JevisonServerApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(JevisonServerApplication.class);
		springApplication.setAdditionalProfiles("dev");
		springApplication.setWebApplicationType(WebApplicationType.NONE);
		springApplication.run(args);
	}
}
