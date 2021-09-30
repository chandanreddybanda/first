package com.example.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstApplication {

	@RequestMapping("/")
  	public String home() {
    		return "Hello World From Cbandas VM";
  	}
	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
		System.out.println("HI FROM CBANDAS VM");
	}

}
