package com.zappts.magicthegathering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MagicthegatheringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicthegatheringApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}
