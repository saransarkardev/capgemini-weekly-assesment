package org.example;

import org.example.dao.CustomerDAO;
import org.example.dao.OrderDAO;
import org.example.entities.Customer;
import org.example.entities.Order;

import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();


//      Customer c1 = new Customer();
//      c1.setCustomerName("Rahul Kumar");
//      c1.setEmail("rahulkumar123@gamil.com");
//      c1.setGender("Male");
//      c1.setPhone(8694385924L);
//      c1.setRegistrationDate(LocalDate.now());
//
//
//
//      Order o1 = new Order();
//
//      o1.setProductName("Samsung Smart TV");
//      o1.setQuantity(1);
//      o1.setOrderNumber("#ORD452");
//      o1.setOrderDate(LocalDate.now());
//      o1.setPrice(60000.0);
//
//      o1.setCustomer(c1);
//      c1.setOrder(o1);
//
//
//      customerDAO.saveCustomer(c1);

        // Fetch By Id
//       Customer c = customerDAO.getCustomerById(1);
//       System.out.println(c);


        //Fetch BY Email
//       Customer s2 = customerDAO.getCustomerByEmail("rahulkumar123@gmail.com");
//       System.out.println(s2);

        //Fetch all Customers
//        List<Customer> customers = customerDAO.getAllCustomers();
//
//        for(Customer c : customers){
//            System.out.println(c);
//        }


        // Update a Customer
//        Customer c = customerDAO.getCustomerById(2);
//        c.setCustomerName("Rahul Das");
//        c.setPhone(8799653233L);
//
//        customerDAO.updateCustomer(c);

        // Delete a customer
//        boolean deleted = customerDAO.deleteCustomer(3);
//
//        System.out.println("Deleted: " + deleted);

        // Update a Order
//        Order order = orderDAO.getOrderById(2);
//        order.setPrice(80000.0);
//        order.setOrderNumber("#ABC123");
//        orderDAO.updateOrder(order);
        
        // Fetch a Order By Id
        Order order = orderDAO.getOrderById(1);
        System.out.println(order);


    }
}