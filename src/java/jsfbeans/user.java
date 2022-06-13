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
import models.Products;
import models.Users;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Named(value = "user")
@ApplicationScoped
public class user {
    
    @EJB
    private AdminbeanLocal ab;

    public user() {
    }
    
    public Collection<Users> showUserData(){
            return ab.getAllUsers();
        }
    
    
}
