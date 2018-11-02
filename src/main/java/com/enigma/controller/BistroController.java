package com.enigma.controller;

import com.enigma.api.Item;
import com.enigma.service.BistroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bistro/")
@Api(value = "Bistro API", description = "API to fetch Bistro details")
public class BistroController {

    BistroService service = new BistroService();

    public BistroController() {
    }

    @GET
    @Path("/menu/")
    @ApiOperation(value = "Get All Items in Menu")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Item> getMenu() {
        return service.getMenu();
    }

    @GET
    @Path("/item/{id}")
    @ApiOperation(value = "Get Item by id")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getItemById(@PathParam("id") Integer id) {
        Item item = service.getItem(id);
        if (item != null)
            return Response.ok(item).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
