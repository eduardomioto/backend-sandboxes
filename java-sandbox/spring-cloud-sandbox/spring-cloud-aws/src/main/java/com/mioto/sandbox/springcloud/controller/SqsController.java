package com.mioto.sandbox.springcloud.controller;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;

import com.mioto.sandbox.springcloud.vo.Person;

public class SqsController {

	@MessageMapping("logicalQueueName")
	private void receiveMessage(Person person, @Header("SenderId") String senderId) {
	    // ...
	}
}
