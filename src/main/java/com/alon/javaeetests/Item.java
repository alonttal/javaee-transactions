package com.alon.javaeetests;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Item.FIND_ALL, query = "select i from Item i")
public class Item {
    public static final String FIND_ALL = "find_all";
    @Id
    private int number;

    public Item(int number) {
        this.number = number;
    }

    public Item() {
    }
}
