package com.sathish.aop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
*
* @author Sathish Kariyanna
*/
@Service
public class HelloWorldService {

	@Value("${name:World}")
	private String name;

	public String getHelloMessage() {
		return "Hello " + this.name;
	}
	public String getGoodByeMessage() {
		return "Good bye " + this.name;
	}

}
