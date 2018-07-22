package com.sathish.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sathish.aop.service.HelloWorldService;
/**
 *
 * @author Sathish Kariyanna
 */

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

	@Autowired
	private HelloWorldService helloWorldService;

	@Override
	public void run(String... args) {
		System.out.println("getHelloMessage : " + this.helloWorldService.getHelloMessage());
		System.out.println( "getGoodByeMessage : " + this.helloWorldService.getGoodByeMessage());
	}

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

}
