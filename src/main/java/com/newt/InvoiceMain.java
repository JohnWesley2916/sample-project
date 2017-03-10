package com.newt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@EnableSwagger2
public class InvoiceMain{
	public static void main(String[] args) {
		/*BasicConfigurator.configure();*/
		SpringApplication.run(InvoiceMain.class, args);
	}
	
	/*@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}*/
}