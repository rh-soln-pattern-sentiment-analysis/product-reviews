package org.globex.retail.client;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.globex.retail.model.dto.ProductReviewDto;

@ApplicationScoped
@RegisterRestClient(configKey = "reviews-sink")
@RegisterClientHeaders(CloudEventHeadersFactory.class)
public interface ReviewSender {

    @POST
    @Path("/")
    void send(ProductReviewDto productReviewDto);

}
