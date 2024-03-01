import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class RootResource {
    
    @ConfigProperty(name="app.entorno")
    String entorno;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Esta aplicación se ha desplegado en un entorno: " + entorno;
    }
}
