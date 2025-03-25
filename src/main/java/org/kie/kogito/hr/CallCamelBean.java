package org.kie.kogito.hr;

import org.apache.camel.ProducerTemplate;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CallCamelBean {

    @Inject
    ProducerTemplate producerTemplate;

    public String callCamelRoute(String payload) {
        // Rufe die Route auf, die in der YAML definiert ist
        Object response = producerTemplate.requestBody("direct:startCamelRoute", payload);
        return response != null ? response.toString() : "No response";
    }
}
