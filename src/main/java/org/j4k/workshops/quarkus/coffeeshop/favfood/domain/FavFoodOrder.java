package org.j4k.workshops.quarkus.coffeeshop.favfood.domain;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@RegisterForReflection
public class FavFoodOrder extends PanacheMongoEntity {

    String customerName;

    String orderId;

    List<FavFoodLineItem> favFoodLineItems;

    public FavFoodOrder() {
    }

    public FavFoodOrder(String customerName, String orderId, List<FavFoodLineItem> favFoodLineItems) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.favFoodLineItems = favFoodLineItems;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FavFoodOrder.class.getSimpleName() + "[", "]")
                .add("customerName='" + customerName + "'")
                .add("orderId='" + orderId + "'")
                .add("favFoodLineItems=" + favFoodLineItems)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavFoodOrder that = (FavFoodOrder) o;
        return Objects.equals(customerName, that.customerName) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(favFoodLineItems, that.favFoodLineItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, orderId, favFoodLineItems);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<FavFoodLineItem> getFavFoodLineItems() {
        return favFoodLineItems;
    }

    public void setFavFoodLineItems(List<FavFoodLineItem> favFoodLineItems) {
        this.favFoodLineItems = favFoodLineItems;
    }
}
