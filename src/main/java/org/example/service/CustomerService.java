package org.example.service;

import org.example.entity.Customer;
import org.example.repository.RepositoryInterface;

import java.util.List;

public class CustomerService extends BaseService implements RepositoryInterface<Customer> {

    @Override
    public boolean create(Customer o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Customer o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Customer findById(int id) {
        session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        session = sessionFactory.openSession();
        List<Customer> customerList = session.createQuery("from Customer ", Customer.class).list();
        session.close();
        return customerList;
    }

    public void close(){
        sessionFactory.close();
    }
}
