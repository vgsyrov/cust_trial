package com.cust_trial.journal.resultscontrolapigateway;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResultsControlApiGatewayApplication {

	public static void main(String[] args) {
//		final ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		SpringApplication.run(ResultsControlApiGatewayApplication.class, args);
	}

}
