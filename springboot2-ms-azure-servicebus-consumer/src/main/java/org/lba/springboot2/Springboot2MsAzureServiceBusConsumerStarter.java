package org.lba.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.lba.springboot2"})
public class Springboot2MsAzureServiceBusConsumerStarter {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2MsAzureServiceBusConsumerStarter.class, args);
	}

}
