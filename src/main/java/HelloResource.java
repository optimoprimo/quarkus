import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
    
    @ConfigProperty(name="app.entorno")
    String entorno;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return entorno;
    }
}
