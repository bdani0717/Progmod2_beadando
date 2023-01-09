package com.springfanclub.beadando.resources;

import bussiness.Reservation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;
import service.ReservationListService;
import service.TableListService;

/**
 *
 * @author 
 */
@Path("jakartaee9")
public class JakartaEE9Resource {

    public Response getTables() {
        return Response
                .ok(TableListService.getFreeTables().toString())
                .build();
    }

    @POST
    @Path("newReservation")
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newReservation(Reservation data) {
        Boolean result = ReservationListService.add(data);

        JSONObject obj = new JSONObject();
        obj.put("added", result);

        return Response
                .ok(obj.toString())
                .build();
    }
}
