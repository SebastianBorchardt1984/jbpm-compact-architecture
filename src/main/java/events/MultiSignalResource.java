package events;

import events.MultiSignalProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * REST-Resource mit zwei Endpoints, um Signale an Kogito zu senden.
 * Hier z.B. "/multi-signal/signal1" und "/multi-signal/signal2".
 */
@Path("/multi-signal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MultiSignalResource {

    private static final Logger LOG = LoggerFactory.getLogger(MultiSignalResource.class);

    @Inject
    MultiSignalProducer multiSignalProducer;

    /**
     * POST /multi-signal/signal1
     * Sendet ein Signal an den Kanal "my-signal1".
     */
    
    /**
     * POST /multi-signal/signal2
     * Sendet ein Signal an den Kanal "my-signal2".
     */
    @POST
    @Path("/signal2")
    public Response sendSignal2(MultiSignalRequest req) {
        if (req == null || req.getProcessInstanceId() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("processInstanceId und payload dürfen nicht null sein!")
                    .build();
        }
        LOG.info("Empfange Request für signal2: instanceId={}, payload={}",
                req.getProcessInstanceId(), req.getPayload());
                System.out.println("Empfange Request für signal2: instanceId=" + req.getProcessInstanceId() + ", payload=" + req.getPayload());

        multiSignalProducer.sendToSignal2(req.getProcessInstanceId(), req.getPayload());

        return Response.ok("Signal2 wurde gesendet.").build();
    }

    /**
     * Hilfsklasse, um die Felder aus dem JSON-Request zu parsen.
     * Hier minimal mit 'processInstanceId' und 'payload'.
     */
    public static class MultiSignalRequest {
        private String processInstanceId;
        private String payload; // Oder Object, falls du komplexe Daten hast

        public String getProcessInstanceId() {
            return processInstanceId;
        }

        public void setProcessInstanceId(String processInstanceId) {
            this.processInstanceId = processInstanceId;
        }

        public String getPayload() {
            return payload;
        }

        public void setPayload(String payload) {
            this.payload = payload;
        }
    }
}
