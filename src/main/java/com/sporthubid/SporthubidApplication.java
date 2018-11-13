package com.sporthubid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class SporthubidApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SporthubidApplication.class, args);
	}

//	@Bean
//	public BCryptPasswordEncoder bcriptEncoder(){
//		return 	new BCryptPasswordEncoder();
//	}

}
