package org.j4k.workshops.quarkus.coffeeshop.infrastructure;

import org.j4k.workshops.quarkus.coffeeshop.favfood.domain.FavFoodOrder;
import org.j4k.workshops.quarkus.coffeeshop.domain.OrderInCommand;
import org.j4k.workshops.quarkus.coffeeshop.favfood.domain.FavFoodOrderHandler;
import org.j4k.workshops.quarkus.coffeeshop.favfood.infrastructure.FavFoodOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api")
public class ApiResource {

    Logger logger = LoggerFactory.getLogger(ApiResource.class);

    @Inject
    KafkaService kafkaService;

    @Inject
    FavFoodOrderRepository repository;

    @POST
    @Path("/favfood")
    public Response acceptFavFoodOrder(final FavFoodOrder favFoodOrder) {

        logger.debug("received {}", favFoodOrder);
        repository.persist(favFoodOrder);

        OrderInCommand orderInCommand = FavFoodOrderHandler.handleOrder(favFoodOrder);

        logger.debug("sending {}", orderInCommand);
        kafkaService.placeOrders(orderInCommand);

        return Response.accepted(favFoodOrder).build();
    }
}