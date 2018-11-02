package com.enigma.dao;

import com.enigma.api.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BistroDao {
    static List<Item> items = new ArrayList<>();

    static {


        items.add(new Item(1, "S1", "Bruschetta"));
        items.add(new Item(2, "S2", "Anise Veg"));
        items.add(new Item(3, "S3", "Thai Fish Cakes"));
        items.add(new Item(4, "S4", "Squid Rings"));

        items.add(new Item(5, "M1", "Ratatouille"));
        items.add(new Item(6, "M2", "Veg Empanadas"));
        items.add(new Item(7, "M3", "Muni Chicken"));
        items.add(new Item(8, "M4", "Steak Italiano"));
    }


    public List<Item> getMenu() {
        return BistroDao.items;
    }

    public Item getItem(int id) {
        Optional<Item> itemLookup = BistroDao.items.stream().filter(item -> item.getId() == id).findAny();
        if (itemLookup.isPresent())
            return itemLookup.get();
        return null;
    }

}
