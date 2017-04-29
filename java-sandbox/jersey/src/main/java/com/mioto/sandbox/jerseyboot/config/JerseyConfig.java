package com.mioto.sandbox.jerseyboot.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.mioto.sandbox.jerseyboot.controller.HealthController;
import com.mioto.sandbox.jerseyboot.controller.HelloController;


@Configuration
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(HealthController.class);
		register(HelloController.class);
		
	}	
}