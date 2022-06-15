/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.*;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Stateless
public class Userbean implements UserbeanLocal {

    @PersistenceContext(unitName = "EcommerceProjectPU")
    EntityManager em;
    
    @Override
    public Users getUser(Integer id) {
        return (Users) em.createNamedQuery("Users.findById");
    }

    @Override
    public Collection<Products> userProducts() {
        return em.createNamedQuery("Products.findAll").getResultList();
    }

    @Override
    public Collection<Carts> userCarts(Users customerId) {
        Query q = em.createNamedQuery("Carts.findByUserId");
        q.setParameter("customerId", customerId);        
        return q.getResultList();
    }

    @Override
    public void addOrder(Integer order_no, Integer user_id, String name, String address, Integer pincode) {
        Users u =  em.find(Users.class, user_id);
        
        Orders o = new Orders();
        o.setOrderNo(order_no);
        o.setUserId(u);
        o.setName(name);
        o.setAddress(address);
        o.setPincode(pincode);
        
        Collection<Orders> orders = u.getOrdersCollection();
        
        orders.add(o);
        u.setOrdersCollection(orders);
        em.persist(o);
        em.merge(u);    
    }
    
    
    @Override
    public void addOrderDetail(Integer order_no_details, Integer product_id, Integer total) {
        OrderDetails o = new OrderDetails();
        Orders on =  em.find(Orders.class, order_no_details);
        Products p =  em.find(Products.class, product_id);
        
        o.setOrderNoDetails(on);
        o.setProductId(p);
        o.setTotal(total);
        
        em.persist(o);   
        
        Collection<OrderDetails> product = p.getOrderDetailsCollection();
        
        
        product.add(o);
        p.setOrderDetailsCollection(product);
        em.merge(p);
    }

    @Override
    public void addPayment(Integer order_no_payment, Integer amount, String method) {
        Orders on =  em.find(Orders.class, order_no_payment);
        
        Payments p = new Payments();
        p.setOrderNoPayment(on);
        p.setTotalAmount(amount);
        p.setPaymentMethod(method);
        em.persist(p);   
    }
    
    @Override
    public Collection<Orders> userOrders(Users user_id) {
        Query q = em.createNamedQuery("Orders.findByUserId");
        q.setParameter("user_id", user_id);        
        return q.getResultList();
    }

    @Override
    public Collection<Reviews> productReviews(Products product_id) {
        Query q = em.createNamedQuery("Orders.findByProductId");
        q.setParameter("product_id", product_id);        
        return q.getResultList();
    }

    @Override
    public Collection<Banners> getactiveBanner() {
        return em.createNamedQuery("Banners.findByIsActive").setParameter("isActive", 1).getResultList();
    }

    @Override
    public Collection<Products> getlatestProduct() {
        return em.createNamedQuery("Products.latestProducts").setMaxResults(5).getResultList();
    }

    @Override
    public Collection<Categories> getAllCategories() {
        return em.createNamedQuery("Categories.findAll").getResultList();
    }

    @Override
    public Products getProduct(Integer id) {
        return (Products) em.createNamedQuery("Products.findById").getSingleResult();
    }

    @Override
    public int addToCart(Integer product_id, Integer customer_id, Integer qty, Integer total) {
        Products p =  em.find(Products.class, product_id);
        Users u =  em.find(Users.class, customer_id);
         try {
            Carts cdata = (Carts) em.createNamedQuery("Carts.findByUser").setParameter("customerId", u).setParameter("productId", p).getSingleResult();
            return 1;
         } catch (Exception e) {
             Carts c = new Carts();
            c.setProductId(p);
            c.setCustomerId(u);
            c.setQty(qty);
            c.setTotal(total);
            em.persist(c);  
            return 0;
        }
        
    }

    @Override
    public void removeCart(Integer cid) {
         Carts c = (Carts) em.find(Carts.class, cid);
        em.remove(c);
    }

}
