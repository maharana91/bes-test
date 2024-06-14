
package com.example.consumingwebservice;

//import com.example.consumingwebservice.stubs.GetCountryResponse;

import com.example.consumingwebservice.stubs.GetPasswordResponse;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		System.setProperty("sun.security.ssl.allowUnsafeRenegotiation","true");
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}



	/*@Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String country = "Spain";
			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = countryClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
		};
	}*/

	/*@Bean
	CommandLineRunner lookup(BESClient besClient) throws Exception {
		GetPasswordResponse response = besClient.getPasswordResponse();
		System.err.println(response.getGetPasswordResult());
        return null;
    }*/

}
