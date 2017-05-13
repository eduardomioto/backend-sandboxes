package com.com.mioto.cloud.consul.cloudconsul;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
public class CloudConsulApplication  extends SpringBootServletInitializer{

	public static void main(String[] args)  {
		new CloudConsulApplication()
		.configure(new SpringApplicationBuilder(CloudConsulApplication.class))
		.run(args);
	}	
}
