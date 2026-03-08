package org.example.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.entities.Customer;

import java.util.List;

public class CustomerDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("assesment");


    public void saveCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.persist(customer);


            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Exception: " + e.getMessage());
        }
        finally {
            em.close();
        }
    }

    public void updateCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.merge(customer);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error updating customer: ", e);
        }
        finally {
            em.close();
        }
    }

    public boolean deleteCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();

            Customer customer = em.find(Customer.class, id);
            if (customer != null) {
                em.remove(customer);
                em.getTransaction().commit();
                return true;
            }
            return false;
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Database error", e);
        } finally {
            em.close();
        }
    }

    public Customer getCustomerById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Customer.class, id);
        }
        catch (Exception e) {
            throw new RuntimeException("Error fetching customer: ", e);
        }
        finally {
            em.close();
        }
    }

    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT c FROM Customer c";
            return em.createQuery(jpql, Customer.class).getResultList();
        }
        catch (Exception e) {
            throw new RuntimeException("Customers not Found: ", e);
        }
        finally {
            em.close();
        }
    }

    public Customer getCustomerByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT c FROM Customer c WHERE c.email = :email";
            TypedQuery<Customer> q = em.createQuery(jpql, Customer.class);
            q.setParameter("email", email);

            List<Customer> customers = q.getResultList();
            if (customers.isEmpty()) {
                return null;
            }
            else {
                return customers.get(0);
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Customer Not Found: ", e);
        }
        finally {
            em.close();
        }
    }


}
