package com.enigma.controller;

import com.enigma.api.Item;
import com.enigma.service.BistroService;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bistro/")
@Api(value = "Bistro API", description = "API to fetch Bistro details")
public class BistroController {

    BistroService service;

    public BistroController(BistroService service) {
        this.service = service;
    }

    @GET
    @UnitOfWork
    @Path("/menu/")
    @ApiOperation(value = "Get All Items in Menu")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Item> getMenu() {
        return service.getMenu();
    }

    @GET
    @UnitOfWork
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

    @POST
    @UnitOfWork
    public Item add(@Valid Item item) {
        Item newItem = service.insert(item);

        return newItem;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Item update(@PathParam("id") Integer id, @Valid Item item) {
        item.setId(id);
        service.update(item);

        return item;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") Integer id) {
        service.delete(id);
    }
    
}
