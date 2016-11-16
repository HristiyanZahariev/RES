package bg.elsys.ip.rest;

import javax.print.attribute.standard.Media;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response postCars(Car car) {
        return Response.ok(GenerateData.getInstance().addNewCar(car)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarById(@PathParam("id") String id) {

        int idx = Integer.parseInt(id);
        return Response.status(200).entity(GenerateData.getInstance().findById(idx)).build();

    }

    //If implementing a dropdown menu
    @Path("/names")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAllDistinctCarManufacturers() {
        return GenerateData.getInstance().getAllDistinctNames();
    }
}
