package events;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class MultiSignalProducer {

    private static final Logger LOG = LoggerFactory.getLogger(MultiSignalProducer.class);

    // Für das erste Signal:

    // Für das zweite Signal:
    @Inject
    @Channel("my-signal2")
    Emitter<String> emitterSignal2;


    /**
     * Sendet ein Event an den Kanal 'my-signal2'.
     */
    public void sendToSignal2(String processInstanceId, Object payload) {
        sendCloudEvent(emitterSignal2, "my-signal2", processInstanceId, payload);
    }

    /**
     * Hilfsmethode zum Bauen eines CloudEvents und Senden über den angegebenen Emitter.
     */
    private void sendCloudEvent(Emitter<String> emitter, String eventType,
                                String processInstanceId, Object payload) {
        try {
            if (processInstanceId == null || processInstanceId.isBlank()) {
                throw new IllegalArgumentException("processInstanceId darf nicht leer sein");
            }
            if (eventType == null || eventType.isBlank()) {
                throw new IllegalArgumentException("eventType darf nicht leer sein");
            }

            String cloudEventJson = createCloudEventJson(processInstanceId, eventType, payload);

            LOG.info("Sende CloudEvent an Kogito: channel={}, instanceId={}, eventType={}, payload={}",
                    eventType, processInstanceId, eventType, payload);

            emitter.send(cloudEventJson);

        } catch (Exception e) {
            LOG.error("Fehler beim Senden des Events an Kogito (channel: {}): {}",
                    eventType, e.getMessage(), e);
        }
    }

    /**
     * Minimaler JSON-String im CloudEvent-Format.
     */
    private String createCloudEventJson(String instanceId, String eventType, Object payload) {
        // 'kogitoprocrefid' => Korrelation mit der Prozessinstanz
        return String.format(
          "{"
          + "\"specversion\":\"1.0\","
          + "\"id\":\"%s\","
          + "\"source\":\"/multi-signal-producer\","
          + "\"type\":\"%s\","
          + "\"kogitoprocrefid\":\"%s\","
          + "\"data\":\"%s\""
          + "}",
          UUID.randomUUID(),
          eventType,
          instanceId,
          payload == null ? "" : payload.toString().replace("\"", "\\\"")
        );
    }
}
