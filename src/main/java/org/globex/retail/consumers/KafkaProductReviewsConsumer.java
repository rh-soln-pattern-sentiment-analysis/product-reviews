package org.globex.retail.consumers;

import io.smallrye.reactive.messaging.kafka.impl.ce.DefaultIncomingKafkaCloudEventMetadata;
import java.util.concurrent.CompletionStage;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
public class KafkaProductReviewsConsumer {

  /*
  You may get conflicts having both producer and consumer in the same project, here is an example anyway.
  Move it to another quarkus project with the 'incoming' configuration from the properties
  to run producer and consumer simultaneously
   */

  //@Incoming("product-reviews")
  //@Acknowledgment(Acknowledgment.Strategy.MANUAL)
  public CompletionStage<Void> process(Message<String> event) {
    var incomingKafkaCloudEventMetadata = event.getMetadata(DefaultIncomingKafkaCloudEventMetadata.class);
    if(incomingKafkaCloudEventMetadata.isEmpty()) {
      throw new IllegalArgumentException("The event does not have CloudEvents metadata.");
    }

    var metadata = incomingKafkaCloudEventMetadata.get();
    System.out.println(metadata.getId()); // the UUID as set on KafkaService.java
    System.out.println(metadata.getType()); // 'product-reviews-event' as set on the application.properties
    System.out.println(metadata.getSource()); // 'product-reviews-service' as set on the application.properties
    if(metadata.getSubject().isPresent())
      System.out.println(metadata.getSubject().get()); // 'Topic for Product Reviews' as set on the application.properties

    System.out.println(event.getPayload()); // your payload, eg.: {"payload": "test"}

    return event.ack();
  }
}
