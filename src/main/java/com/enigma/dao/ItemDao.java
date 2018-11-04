package com.enigma.dao;

import com.enigma.api.Item;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDao extends AbstractDAO<Item> {

    public ItemDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }



    public List<Item> getMenu() {
        Query query = currentSession().getNamedQuery("com.enigma.api.findAll");
        return (List<Item>) query.getResultList();
    }

    public Item getItem(int id) {
        return currentSession().get(Item.class, id);
    }

    public void delete(int id) {
        Item item = currentSession().get(Item.class, id);
        if(item != null)
            currentSession().delete(item);
    }

    public void update(Item item) {
        currentSession().saveOrUpdate(item);
    }

    public Item insert(Item item) {
        return persist(item);
    }

}
