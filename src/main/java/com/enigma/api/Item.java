package com.enigma.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "item")
@NamedQueries({
        @NamedQuery(name = "com.enigma.api.findAll",
                query = "select i from Item i")
})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public Item() {
    }

    public Item(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    public String getCode() {
        return code;
    }

    @JsonProperty
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                Objects.equals(code, item.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }

    @Override
    public String toString() {
        return "Item: ID= " + id + " Code= " + code+ " Name= " + name;
    }
}
