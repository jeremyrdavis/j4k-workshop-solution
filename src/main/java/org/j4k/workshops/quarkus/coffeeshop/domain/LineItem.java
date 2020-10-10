package org.j4k.workshops.quarkus.coffeeshop.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;
import java.util.StringJoiner;

@RegisterForReflection
public class LineItem {

    String item;

    String name;

    public LineItem() {
    }

    public LineItem(String item, String name) {
        this.item = item;
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LineItem.class.getSimpleName() + "[", "]")
                .add("item='" + item + "'")
                .add("name='" + name + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Objects.equals(item, lineItem.item) &&
                Objects.equals(name, lineItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, name);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
