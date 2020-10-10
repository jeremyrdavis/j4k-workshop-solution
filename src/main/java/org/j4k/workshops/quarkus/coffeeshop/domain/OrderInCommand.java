package org.j4k.workshops.quarkus.coffeeshop.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@RegisterForReflection
public class OrderInCommand {

    String id;

    List<LineItem> beverages = new ArrayList<>();

    List<LineItem> kitchenOrders = new ArrayList<>();

    public OrderInCommand() {
    }

    public OrderInCommand(String id, List<LineItem> beverages, List<LineItem> kitchenOrders) {
        this.id = id;
        this.beverages = beverages;
        this.kitchenOrders = kitchenOrders;
    }

    public void addBeverage(final LineItem lineItem) {
        getBeverages().add(lineItem);
    }

    public void addKitchenOrder(final LineItem lineItem) {
        getKitchenOrders().add(lineItem);
    }

        @Override
    public String toString() {
        return new StringJoiner(", ", OrderInCommand.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("beverages=" + beverages)
                .add("kitchenOrders=" + kitchenOrders)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInCommand that = (OrderInCommand) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(beverages, that.beverages) &&
                Objects.equals(kitchenOrders, that.kitchenOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beverages, kitchenOrders);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<LineItem> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<LineItem> beverages) {
        this.beverages = beverages;
    }

    public List<LineItem> getKitchenOrders() {
        return kitchenOrders;
    }

    public void setKitchenOrders(List<LineItem> kitchenOrders) {
        this.kitchenOrders = kitchenOrders;
    }

}
