package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Sale;
import org.example.entity.SaleLine;
import org.example.entity.StateSale;
import org.example.repository.RepositoryInterface;

import java.util.List;

public class SaleService extends BaseService implements RepositoryInterface<Sale> {
    @Override
    public boolean create(Sale o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Sale o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Sale o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Sale findById(int id) {
        session = sessionFactory.openSession();
        Sale sale = session.get(Sale.class,id);
        session.close();
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        session = sessionFactory.openSession();
        List<Sale> saleList = session.createQuery("from Sale ", Sale.class).list();
        session.close();
        return saleList;
    }

    public int createAndReturnId(Sale o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        int id = o.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public boolean addSaleLine(int id, SaleLine saleLine){
        boolean result = false;
        Sale sale = findById(id);
        session = sessionFactory.openSession();
        session.beginTransaction();

        if(sale != null){
            sale = (Sale) session.merge(sale);
            SaleLine existingSaleLine = session.get(SaleLine.class, saleLine.getId());

            if (existingSaleLine != null) {
                existingSaleLine.setQuantity(saleLine.getQuantity());
                existingSaleLine.setTotal(saleLine.getTotal());
                session.update(existingSaleLine);
            } else {
                sale.getSaleLines().add(saleLine);
                session.update(sale);
            }

            result = true;
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void updateStateSale(int id, StateSale state){
        Sale sale = findById(id);
        sale.registerObserver(sale.getCustomer());
        session = sessionFactory.openSession();
        session.beginTransaction();
        sale.setStateSale(state);
        sale.notifyObservers();
        session.update(sale);
        session.getTransaction().commit();
        session.close();
    }

    public void close(){
        sessionFactory.close();
    }
}
