package com.enigma.controller;

import com.enigma.api.Item;
import com.enigma.service.BistroService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bistro")
@Produces(MediaType.APPLICATION_JSON)
public class BistroController {

    BistroService service = new BistroService();

    public BistroController() {
    }

    @GET
    public List<Item> getMenu() {
        return service.getMenu();
    }

    @GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") Integer id) {
        Item item = service.getItem(id);
        if (item != null)
            return Response.ok(item).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
