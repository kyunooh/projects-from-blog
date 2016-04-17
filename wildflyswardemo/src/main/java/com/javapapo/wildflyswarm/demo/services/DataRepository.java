package com.javapapo.wildflyswarm.demo.services;

import com.javapapo.wildflyswarm.demo.model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="mailto:javapapo@mac.com">javapapo</a> on 19/01/16.
 */
@ApplicationScoped
public class DataRepository {

    private static List<User> users= new ArrayList<>();


    public List<User> getUsers(){
        return users;
    }


    @PostConstruct
    public void init(){
        User papo= new User("papo");
        papo.setName("Paris");

        User jane= new User("jane");
        jane.setName("Jane");

        List<User> result = new ArrayList<>();
        users.add(papo);
        users.add(jane);
    }

}
