package com.enigma.service;

import com.enigma.api.Item;
import com.enigma.dao.ItemDao;

import java.util.List;

public class BistroService {

    ItemDao dao;

    public BistroService(ItemDao dao) {
        this.dao = dao;
    }

    public List<Item> getMenu() {
        return dao.getMenu();
    }

    public Item getItem(int id) {
        return dao.getItem(id);
    }

    public Item insert(Item item) {
        return dao.insert(item);
    }

    public Item update(Item Item) {
        dao.update(Item);

        return Item;
    }

    public void delete(int id) {
        dao.delete(id);
    }

}
