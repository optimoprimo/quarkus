package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @ConfigProperty(name = "propertie")
    String propertie;

    @ConfigProperty(name = "configmap")
    String configmap;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return propertie + configmap;
    }
}
