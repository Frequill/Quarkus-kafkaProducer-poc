package Functionality;

import Entities.Request;
import Entities.Response;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/requestResource")
public class RequestResource {

    @Channel("requests") // Will be our topic in kafka
    Emitter<Request> requestEmitter;

    @Channel("responses") // Topic with name "responses"
    Multi<Response> responseMulti;


    /**
     * Allows user to create a request entity from json input, then sends said request to kafka topic "requests"

     * Create account: curl -H "Content-Type: application/json" -H "Accepts: application/json" -X POST -d '{"id":"createAccount", "dataString":"username,***,password,***,email,***"}' "http://localhost:8080/requestResource/requests"
     * Login: curl -H "Content-Type: application/json" -H "Accepts: application/json" -X POST -d '{"id":"login", "dataString":"username,***,password,***"}' "http://localhost:8080/requestResource/requests"
     * Logout: curl -H "Content-Type: application/json" -H "Accepts: application/json" -X POST -d '{"id":"logout", "dataString":"username,***"}' "http://localhost:8080/requestResource/requests"
     * Delete account: curl -H "Content-Type: application/json" -H "Accepts: application/json" -X POST -d '{"id":"deleteAccount", "dataString":"username,***,password,***"}' "http://localhost:8080/requestResource/requests"

     */
    @POST
    @Path("/requests")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> createRequest(Request request) {
        requestEmitter.send(request);

        // This way, the latest response will be returned to frontend as a Uni containing the response! (Thanks to Rasmus!)
        return responseMulti.toUni();
    }




}