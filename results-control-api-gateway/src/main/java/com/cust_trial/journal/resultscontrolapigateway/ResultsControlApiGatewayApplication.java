package com.cust_trial.journal.resultscontrolapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResultsControlApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResultsControlApiGatewayApplication.class, args);
	}

}
