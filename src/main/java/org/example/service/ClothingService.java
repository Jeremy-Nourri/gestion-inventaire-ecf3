package org.example.service;

import org.example.entity.Clothing;
import org.example.repository.RepositoryInterface;

import java.util.List;

public class ClothingService extends BaseService implements RepositoryInterface<Clothing> {

    public ClothingService() {
        super();
    }

    @Override
    public boolean create(Clothing o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Clothing o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Clothing o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Clothing findById(int id) {
        session = sessionFactory.openSession();
        Clothing clothing = session.get(Clothing.class, id);
        session.close();
        return clothing;
    }

    @Override
    public List<Clothing> findAll() {
        session = sessionFactory.openSession();
        List<Clothing> clothingList = session.createQuery("from Clothing ", Clothing.class).list();
        session.close();
        return clothingList;
    }

    public void close(){
        sessionFactory.close();
    }
}