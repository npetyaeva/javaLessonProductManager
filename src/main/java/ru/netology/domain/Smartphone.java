package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String maker;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String maker) {
        super(id, name, price);
        this.maker = maker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(maker, that.maker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maker);
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || this.getMaker().contains(search);
    }
}