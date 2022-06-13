/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsfbeans;

import beans.AdminbeanLocal;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import models.Orders;
import models.Users;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Named(value = "order")
@ApplicationScoped
public class order {

    @EJB
    private AdminbeanLocal ab;

    public order() {
    }
    
    public Collection<Orders> showOrderData(){
       return ab.getAllOrders();
    }
    
}
