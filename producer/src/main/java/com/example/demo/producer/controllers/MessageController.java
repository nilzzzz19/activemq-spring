package com.example.demo.producer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.producer.services.Producer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
	
	Producer producer;
	
	public MessageController(Producer producer) {
		this.producer=producer;
	}

	@GetMapping("/send")
	public String publishMessage(@RequestParam("message") String message) {
		producer.sendMessageToTopic(message); //calls service
		return "Successfully sent!!";
		
	}
}
