package com.mmtechsoft.api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.corecompete.smscinbound" })
public class MyApplication {

	public static void main(String[] args) {
		System.out.println("MyApplication Started Here ");
		SpringApplication.run(MyApplication.class, args);
		System.out.println("MyApplication Ended Here ");
	}
}