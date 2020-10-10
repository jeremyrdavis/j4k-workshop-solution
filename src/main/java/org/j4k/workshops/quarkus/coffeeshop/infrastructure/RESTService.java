package org.j4k.workshops.quarkus.coffeeshop.infrastructure;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.j4k.workshops.quarkus.coffeeshop.domain.OrderInCommand;

import javax.annotation.PostConstruct;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;

@Path("/order")
@RegisterRestClient
public interface RESTService {

    @POST
    CompletionStage<Response> placeOrders(final OrderInCommand orderInCommand);
}
