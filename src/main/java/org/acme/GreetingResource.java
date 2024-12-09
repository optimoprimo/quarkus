package org.acme;

import java.util.HashMap;
import java.util.Map;

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
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> hello() {
        var mapa = new HashMap<String,String>();
        mapa.put("CONFIGMAP", configmap);
        mapa.put("SECRETO", propertie);
        return mapa;
    }
}
