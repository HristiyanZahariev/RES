package bg.elsys.ip.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hristiyan on 14.11.16.
 */
@Api("cars")
@Path("/cars")
public class CarResource {
    @ApiOperation(value = "Get request that returns a list of cars", response = Car.class, responseContainer = "List")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCars(
            @QueryParam("manufacture") String manufacturer,
            @QueryParam("model") String model,
            @QueryParam("year") Integer year,
            @QueryParam("color") String color,
            @QueryParam("currentPage") Integer currentPage,
            @QueryParam("carsPerPage") Integer carsPerPage) {

            return Response.ok(GenerateData.getInstance().filterCars(manufacturer, model, year, color, currentPage, carsPerPage)).build();
            //return Response.ok(GenerateData.getInstance().getCars()).build();
    }
    @ApiOperation(value = "Post", response = Car.class)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postCars(Car car) {
        GenerateData.getInstance().addNewCar(car);
        return Response.ok(car).build();
    }

    @ApiOperation(value = "Get request for a specific car in the list", response = Car.class, responseContainer = "List")
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarById(@PathParam("id") String id) {

        int idx = Integer.parseInt(id);
        return Response.status(200).entity(GenerateData.getInstance().findById(idx)).build();

    }

    //If implementing a dropdown menu
    @ApiOperation(value = "Get request for getting all manufacturers from the list", response = Car.class, responseContainer = "List")
    @Path("/names")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDistinctCarManufacturers() {
        return Response.ok(GenerateData.getInstance().getAllManufacturersNames()).build();
    }

    @ApiOperation(value = "Get request for getting all models from the list", response = Car.class, responseContainer = "List")
    @Path("/models")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDistinctCarModels() {
        return Response.ok(GenerateData.getInstance().getAllModelNames()).build();
    }

    @ApiOperation(value = "Get request for getting all years from the list", response = Car.class, responseContainer = "List")
    @Path("/years")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDistinctCarYears() {
        return Response.ok(GenerateData.getInstance().getAllYears()).build();
    }


    @ApiOperation(value = "Get request for getting all colors from the list", response = Car.class, responseContainer = "List")
    @Path("/colors")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDistinctColors() {
        return Response.ok(GenerateData.getInstance().getAllColors()).build();
    }


}
