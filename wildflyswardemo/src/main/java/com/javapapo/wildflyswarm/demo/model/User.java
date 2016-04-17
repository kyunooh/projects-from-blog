package com.javapapo.wildflyswarm.demo.model;

/**
 * Simple User POJO
 * Created by <a href="mailto:javapapo@mac.com">javapapo</a> on 19/01/16.
 */
public class User {

    private String userName;
    private String name;

    public User(String aUserName){
        this.userName = aUserName;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
