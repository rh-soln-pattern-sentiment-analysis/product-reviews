package org.globex.retail.client;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import java.util.concurrent.atomic.AtomicLong;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

@ApplicationScoped
public class CloudEventHeadersFactory implements ClientHeadersFactory {

    AtomicLong id = new AtomicLong();
    
    @ConfigProperty(name = "cloudevents.ce-type", defaultValue="!") 
    String ceType;

    @ConfigProperty(name = "cloudevents.ce-specversion", defaultValue="1.0") 
    String ceSpecVersion;

    @ConfigProperty(name = "cloudevents.ce-source", defaultValue="!") 
    String ceSource;


    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incoming,
                                                 MultivaluedMap<String, String> outgoing) {
        MultivaluedMap<String, String> result = new MultivaluedHashMap<>();
        result.add("Ce-Id", String.valueOf(id.incrementAndGet()));
        result.add("Ce-Specversion", ceSpecVersion);
        result.add("Ce-Type", ceType);
        result.add("Ce-Source", ceSource);
        return result;
    }

}
