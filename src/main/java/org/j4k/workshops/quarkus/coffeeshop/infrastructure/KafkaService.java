package org.j4k.workshops.quarkus.coffeeshop.infrastructure;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.j4k.workshops.quarkus.coffeeshop.domain.OrderInCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class KafkaService {

    Logger logger = LoggerFactory.getLogger(KafkaService.class);

    Jsonb jsonb = JsonbBuilder.create();

    @Inject
    @Channel("orders")
    Emitter<String> ordersEmitter;

    public CompletableFuture<Void> placeOrders(OrderInCommand orderInCommand) {

        logger.debug("sending {}", orderInCommand);
        return ordersEmitter.send(jsonb.toJson(orderInCommand)).toCompletableFuture();
    }
}
