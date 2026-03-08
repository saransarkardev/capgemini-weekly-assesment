package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Order;

public class OrderDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("assesment");

    public Order getOrderById(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Order.class, id);
        }
        catch (Exception e) {
            throw new RuntimeException("Order Not Found: ", e);
        }
        finally {
            em.close();
        }
    }

    public void updateOrder(Order order) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(order);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Order Not Found: ", e);
        }
        finally {
            em.close();
        }
    }
}
