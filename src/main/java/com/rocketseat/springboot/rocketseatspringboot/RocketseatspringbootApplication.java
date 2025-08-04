package com.rocketseat.springboot.rocketseatspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rocketseat.springboot") //informamaos que tudo que estiver dentro desse pacote deve ser gerenciado e lido
public class RocketseatspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketseatspringbootApplication.class, args);
	}

}
