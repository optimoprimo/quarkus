package org.acme;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class HomeResource {

    @ConfigProperty(name = "properti_one")
    String properti_one;

    @ConfigProperty(name = "properti_two")
    String properti_two;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> home() {
        var mapa = new HashMap<String,String>();
        mapa.put("PROPERTI_ONE", properti_one);
        mapa.put("PROPERTI_TWO", properti_two);
        return mapa;
    }
}
