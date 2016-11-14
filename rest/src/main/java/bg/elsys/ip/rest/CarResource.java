package bg.elsys.ip.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hristiyan on 14.11.16.
 */
@Path("/cars")
public class CarResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCars() {
        return Response.ok(GenerateData.getCars()).build();
    }
}
