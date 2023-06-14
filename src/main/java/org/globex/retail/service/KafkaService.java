package org.globex.retail.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.globex.retail.client.ReviewSender;
import org.globex.retail.model.dto.ProductReviewDto;



@ApplicationScoped
public class KafkaService {
    
    @RestClient
    @Inject
    private ReviewSender reviewSender;

    public void emit(ProductReviewDto payload) {
        reviewSender.send(payload);        
    }
   
}
