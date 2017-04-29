package com.mioto.sandbox.jerseyboot.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;


@Component
@Path("/hello")
public class HelloController {

	@GET
    public String health() {
        return "Hello";
    }
    
}