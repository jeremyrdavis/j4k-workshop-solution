package org.j4k.workshops.quarkus.coffeeshop.favfood.infrastructure;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.j4k.workshops.quarkus.coffeeshop.favfood.domain.FavFoodOrder;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FavFoodOrderRepository implements PanacheMongoRepository<FavFoodOrder> {
}
