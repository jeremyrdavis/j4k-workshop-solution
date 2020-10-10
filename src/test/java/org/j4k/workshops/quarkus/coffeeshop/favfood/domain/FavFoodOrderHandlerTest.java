package org.j4k.workshops.quarkus.coffeeshop.favfood.domain;

import org.j4k.workshops.quarkus.coffeeshop.domain.FavFoodLineItem;
import org.j4k.workshops.quarkus.coffeeshop.domain.FavFoodOrder;
import org.j4k.workshops.quarkus.coffeeshop.domain.LineItem;
import org.j4k.workshops.quarkus.coffeeshop.domain.OrderInCommand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FavFoodOrderHandlerTest {


    @Test
    public void testHandleOrder() {

        FavFoodOrder favFoodOrder = new FavFoodOrder();
        favFoodOrder.setCustomerName("Spock");
        favFoodOrder.setOrderId(UUID.randomUUID().toString());
        favFoodOrder.setFavFoodLineItems(
                new ArrayList<>(
                    Arrays.asList(
                            new FavFoodLineItem("COFFEE_BLACK", UUID.randomUUID().toString(), 1)
                    )));

        OrderInCommand expectedOrderInCommand = FavFoodOrderHandler.handleOrder(favFoodOrder);

        assertEquals(1, expectedOrderInCommand.getBeverages().size());
        LineItem beverage = expectedOrderInCommand.getBeverages().get(0);
        assertEquals("COFFEE_BLACK", beverage.getItem());
    }
}
