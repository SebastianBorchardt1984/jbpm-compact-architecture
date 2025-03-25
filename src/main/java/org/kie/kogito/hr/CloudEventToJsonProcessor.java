package org.kie.kogito.hr;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;
import io.cloudevents.core.data.PojoCloudEventData;

@ApplicationScoped
@Named("cloudEventToJsonProcessor")
public class CloudEventToJsonProcessor implements Processor {

    @Inject
    ObjectMapper objectMapper;

    @Override
    public void process(Exchange exchange) throws Exception {
        CloudEvent event = exchange.getMessage().getBody(CloudEvent.class);
        if (event == null) {
            exchange.getMessage().setBody("{}");
            return;
        }
        // Erstellen einer Map für das Ergebnis
        Map<String, Object> result = new HashMap<>();
        
        // CloudEvent-Metadaten hinzufügen
        result.put("id", event.getId());
        result.put("source", event.getSource() != null ? event.getSource().toString() : null);
        result.put("type", event.getType());
        if (event.getTime() != null) {
            result.put("time", event.getTime().toString());
        }
        
        // Extensions (wie z.B. kogitoprocinstanceid, kogitoproctype, etc.) hinzufügen
        if (event.getExtensionNames() != null) {
            for (String extensionName : event.getExtensionNames()) {
                result.put(extensionName, event.getExtension(extensionName));
            }
        }
        
        // Datenfeld verarbeiten
        CloudEventData data = event.getData();
        if (data != null) {
            Object value;
            if (data instanceof PojoCloudEventData) {
                value = ((PojoCloudEventData<?>) data).getValue();
            } else {
                value = new String(data.toBytes(), StandardCharsets.UTF_8);
            }
            // Falls der Payload ein Map ist, die einzelnen Felder auf Top-Level mergen
            if (value instanceof Map) {
                result.putAll((Map<String, Object>) value);
            } else {
                // Andernfalls als "data" ablegen
                result.put("data", value);
            }
        }
        
        // Ergebnis als JSON-String serialisieren
        String json = objectMapper.writeValueAsString(result);
        exchange.getMessage().setBody(json);
    }
}
