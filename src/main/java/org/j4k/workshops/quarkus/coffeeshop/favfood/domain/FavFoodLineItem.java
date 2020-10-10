package org.j4k.workshops.quarkus.coffeeshop.favfood.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;
import java.util.StringJoiner;

@RegisterForReflection
public class FavFoodLineItem {

    String item;

    String itemId;

    int quantity;

    public FavFoodLineItem() {
    }

    public FavFoodLineItem(String item, String itemId, int quantity) {
        this.item = item;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FavFoodLineItem.class.getSimpleName() + "[", "]")
                .add("item='" + item + "'")
                .add("itemId='" + itemId + "'")
                .add("quantity=" + quantity)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavFoodLineItem that = (FavFoodLineItem) o;
        return quantity == that.quantity &&
                Objects.equals(item, that.item) &&
                Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, itemId, quantity);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
