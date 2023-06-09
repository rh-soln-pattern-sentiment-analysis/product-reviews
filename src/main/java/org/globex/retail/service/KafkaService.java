package org.globex.retail.service;

import io.smallrye.reactive.messaging.ce.OutgoingCloudEventMetadata;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
public class KafkaService {

    //@Inject
    //@Channel("product-reviews")
    Emitter<String> emitter;

    public void emit(String payload) {
        var metadata = getMetadata();
        var msg = toMessage(payload, metadata);
        emitter.send(msg);
    }

    private Message<String> toMessage(String payload, OutgoingCloudEventMetadata metadata) {
        return Message.of(payload).addMetadata(metadata)
            .withAck(() -> {
                // Called when the message is acked
                System.out.println("Kafka acked event message: ");
                return CompletableFuture.completedFuture(null);
            })
            .withNack(throwable -> {
                // Called when the message is nacked
                System.err.println("Kafka nacked event message: " + throwable.getMessage());
                return CompletableFuture.completedFuture(null);
            });
    }

    private OutgoingCloudEventMetadata getMetadata() {
        return OutgoingCloudEventMetadata.builder()
            .withId(UUID.randomUUID().toString())
            .withType("product-reviews-event")
            .build();
    }
}
