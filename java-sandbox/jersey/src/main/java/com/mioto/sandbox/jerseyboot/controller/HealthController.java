package com.mioto.sandbox.jerseyboot.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.mioto.sandbox.jerseyboot.vo.Health;


@Component
@Path("/check")
public class HealthController {

	@GET
    @Produces("application/json")
    public Health health() {
        return new Health("Jersey: Up and Running!");
    }
    
}