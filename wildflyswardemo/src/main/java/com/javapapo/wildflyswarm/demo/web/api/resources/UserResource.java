package com.javapapo.wildflyswarm.demo.web.api.resources;

import com.javapapo.wildflyswarm.demo.model.User;
import com.javapapo.wildflyswarm.demo.services.DataRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by <a href="mailto:javapapo@mac.com">javapapo</a> on 19/01/16.
 */
@Path("/users")
public class UserResource {

    @Inject
    DataRepository dataRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> get(){
        return dataRepository.getUsers();

    }


}
