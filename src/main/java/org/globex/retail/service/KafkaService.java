package org.globex.retail.service;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.ce.OutgoingCloudEventMetadata;

@ApplicationScoped
public class KafkaService {

    @Inject
    @Channel("product-reviews")
    Emitter<String> emitter;

    
    public void emit(String payload) {
        //emitter.send(toMessage(payload));
        
        var metadata = OutgoingCloudEventMetadata.builder()
                .withType("reviews")
                .build();

        emitter.send(Message.of(payload).addMetadata(metadata));
        
    }

    private Message<String> toMessage(String payload) {
        return Message.of(payload);
    }

    /* @Outgoing("cloud-events")
    public Message<String> emit(String payload) {
        Message<String> in = Message.of(payload);
        return in.addMetadata(OutgoingCloudEventMetadata.builder()
      .withId("id-" + in.getPayload())
      .withType("reviews")
      .withSource(URI.create("reviews-generators"))
      .withSubject("product-reviews") .build());
    } */
}
