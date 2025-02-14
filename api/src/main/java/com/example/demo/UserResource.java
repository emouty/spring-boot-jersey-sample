package com.example.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public interface UserResource {


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    String getUser(@PathParam("id") int id);
}
