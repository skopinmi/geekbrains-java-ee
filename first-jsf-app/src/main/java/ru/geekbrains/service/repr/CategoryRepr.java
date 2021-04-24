package ru.geekbrains.service.repr;

import java.io.Serializable;

public class CategoryRepr implements Serializable {

    long id;
    String name;

    public CategoryRepr() {
    }

    public CategoryRepr(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
