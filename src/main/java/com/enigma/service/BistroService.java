package com.enigma.service;

import com.enigma.api.Item;
import com.enigma.dao.BistroDao;

import java.util.List;

public class BistroService {

    BistroDao dao = new BistroDao();

    public List<Item> getMenu() {
        return dao.getMenu();
    }

    public Item getItem(int id) {
        return dao.getItem(id);
    }


}
