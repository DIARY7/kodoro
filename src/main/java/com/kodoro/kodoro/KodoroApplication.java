package com.kodoro.kodoro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KodoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodoroApplication.class, args);
	}
	//ponderer = sommQte*pRivientusuel/SommeQte group by usuel
}
