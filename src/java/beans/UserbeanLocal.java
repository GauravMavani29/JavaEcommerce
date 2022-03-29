/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import java.util.Collection;
import javax.ejb.Local;
import models.*;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Local
public interface UserbeanLocal {
      // User
    Users getUser(Integer id);
    
    // Product
    Collection<Products> userProducts();
    
    //Cart
    Collection<Carts> userCarts(Users user_id);
    
    //Order
    void addOrder(Integer order_no, Integer user_id, String name, String address, Integer pincode);
    
    //OrderDetails
    void addOrderDetail(Integer order_no, Integer product_id, Integer total);
    
    //Payments
    void addPayment(Integer order_no, Integer amount, String method);
    
    Collection<Orders> userOrders(Users user_id);
    
    //Reviews
    Collection<Reviews> productReviews(Products product_id);
}
