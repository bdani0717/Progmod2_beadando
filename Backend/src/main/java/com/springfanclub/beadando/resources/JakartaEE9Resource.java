package com.springfanclub.beadando.resources;

import bussiness.Reservation;
import bussiness.Table;
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

    @GET
    @Path("tables")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTables() {
        return Response
                .ok(TableListService.getTables().toString())
                .build();
    }

    @POST
    @Path("newReservation")
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newReservation(Reservation data) {
        JSONObject result = ReservationListService.add(data);

        return Response
                .ok(result.toString())
                .build();
    }

    @POST
    @Path("newTable")
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTable(Table data) {
        Boolean result = TableListService.add(data);

        JSONObject obj = new JSONObject();
        obj.put("success", result);

        return Response
                .ok(obj.toString())
                .build();
    }

    @POST
    @Path("deleteReservation")
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteReservation(int reservationId) {
        Boolean result = ReservationListService.delete(reservationId);

        JSONObject obj = new JSONObject();
        obj.put("success", result);

        return Response
                .ok(obj.toString())
                .build();
    }
}
