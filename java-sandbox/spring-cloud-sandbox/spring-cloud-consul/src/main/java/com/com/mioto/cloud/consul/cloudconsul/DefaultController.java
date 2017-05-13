package com.com.mioto.cloud.consul.cloudconsul;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;


@Component
@Path("/default")
public class DefaultController {

	@GET
    public String health() {
        return "Hello";
    }
    
}