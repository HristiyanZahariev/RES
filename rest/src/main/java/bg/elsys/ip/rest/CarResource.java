package bg.elsys.ip.rest;

import javax.ws.rs.*;
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
        return Response.ok(GenerateData.getInstance().getCars()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN )
    public Response postCars(Car car) {
        boolean addResult = GenerateData.getInstance().add(car);
        return Response.ok(addResult).build();
    }

    
}
