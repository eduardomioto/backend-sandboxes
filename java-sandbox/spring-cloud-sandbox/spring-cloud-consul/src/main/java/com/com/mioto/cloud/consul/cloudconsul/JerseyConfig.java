package com.com.mioto.cloud.consul.cloudconsul;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(HelloController.class);
		register(DefaultController.class);
	}
}