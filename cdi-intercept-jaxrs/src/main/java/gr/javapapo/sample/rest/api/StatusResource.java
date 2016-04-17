
package gr.javapapo.sample.rest.api;

import gr.javapapo.sample.cdi.CheckRequest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

/**
 * JARX Resource implementing a simple status endpoint
 * Created by <a href="mailto:javapapo@mac.com">javapapo</a> on 24/09/15.
 */
@Path("/status")
public class StatusResource {

    /**
     * Returns a simple JSON object, regarding the app status, n
     *
     * @return Response <JsonObject>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CheckRequest(role="ADMIN")
    public Response getStatus() {
        JsonObject object = Json.createObjectBuilder()
                .add("status", "Status with CDI internceptor check,It Works at " + LocalDateTime.now().toString())
                .build();
        Response.ResponseBuilder repBuilder = Response.ok().entity(object);
        return repBuilder.build();
    }


    /**
     * Returns a simple JSON object, regarding the app status, n
     *
     * @return Response <JsonObject>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/nocheck")
    public Response getStatusNoCheck() {
        JsonObject object = Json.createObjectBuilder()
                .add("status", "It Works at " + LocalDateTime.now().toString())
                .build();
        Response.ResponseBuilder repBuilder = Response.ok().entity(object);
        return repBuilder.build();
    }

}
