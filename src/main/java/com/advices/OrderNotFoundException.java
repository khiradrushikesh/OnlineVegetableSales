package com.advices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
public class OrderNotFoundException extends Exception{
	public OrderNotFoundException(String message) {
		super(message);
	}
}