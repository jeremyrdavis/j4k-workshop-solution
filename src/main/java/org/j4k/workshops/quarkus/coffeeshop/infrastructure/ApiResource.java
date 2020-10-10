package org.j4k.workshops.quarkus.coffeeshop.infrastructure;

import org.j4k.workshops.quarkus.coffeeshop.domain.FavFoodOrder;
import org.j4k.workshops.quarkus.coffeeshop.domain.OrderInCommand;
import org.j4k.workshops.quarkus.coffeeshop.favfood.domain.FavFoodOrderHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api")
public class ApiResource {

    Logger logger = LoggerFactory.getLogger(ApiResource.class);

    @POST
    @Path("/favfood")
    public Response acceptFavFoodOrder(final FavFoodOrder favFoodOrder) {

        logger.debug("received {}", favFoodOrder);

        OrderInCommand orderInCommand = FavFoodOrderHandler.handleOrder(favFoodOrder);

        logger.debug("sending {}", orderInCommand);

        return Response.accepted(favFoodOrder).build();
    }
}