package com.javapapo.wildflyswarm.demo;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * Main app, to init the container, create the app archive , start and deploy the container
 * Created by <a href="mailto:javapapo@mac.com">javapapo</a> on 19/01/16.
 */
public class BooStrap {

    /**
     * Using ShrinkWrap to create the war and deploy it.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Container container = new Container();
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "demo.war");
        deployment.addPackages(true,"com.javapapo.wildflyswarm.demo.web");
        deployment.addPackages(true,"com.javapapo.wildflyswarm.demo.model");
        deployment.addPackages(true,"com.javapapo.wildflyswarm.demo.services");
        deployment.addAllDependencies();
        container.start().deploy(deployment);
    }
}
