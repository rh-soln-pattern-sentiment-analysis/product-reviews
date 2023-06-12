package org.globex.retail.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.globex.retail.model.dto.ProductReviewDto;

import io.smallrye.reactive.messaging.ce.OutgoingCloudEventMetadata;

@ApplicationScoped
public class KafkaService {

    @Inject
    @Channel("product-reviews")
    Emitter<ProductReviewDto> emitter;

    
    public void emit(ProductReviewDto payload) {
        //emitter.send(toMessage(payload));
        
        var metadata = OutgoingCloudEventMetadata.builder()
                .withType("reviews")
                .build();

        emitter.send(Message.of(payload).addMetadata(metadata));
        
    }
   
}
