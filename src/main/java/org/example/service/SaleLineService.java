package org.example.service;

import org.example.entity.SaleLine;
import org.example.repository.RepositoryInterface;

import java.util.List;

public class SaleLineService extends BaseService  {


    public int create(SaleLine o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        int id = o.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public boolean update(SaleLine o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean delete(SaleLine o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }


    public SaleLine findById(int id) {
        session = sessionFactory.openSession();
        SaleLine saleLine = session.get(SaleLine.class, id);
        session.close();
        return saleLine;
    }


    public List<SaleLine> findAll() {
        session = sessionFactory.openSession();
        List<SaleLine> saleLineList = session.createQuery("from SaleLine ", SaleLine.class).list();
        session.close();
        return saleLineList;
    }
}
