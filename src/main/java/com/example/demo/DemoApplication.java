package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/cat")
	public CatFact catDetails(){
		String url = "https://catfact.ninja/fact?max_length=140";

		WebClient.Builder builder = WebClient.builder();

		CatFact catFact = builder.build()
				.get().uri(url)
				.retrieve()
				.bodyToMono(CatFact.class)
				.block();
		return catFact;
	}


}
