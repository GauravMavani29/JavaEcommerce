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
import models.Reviews;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Named(value = "review")
@ApplicationScoped
public class review {

     @EJB
    private AdminbeanLocal ab;

    public review() {
    }
    
    public Collection<Reviews> showReviewData(){
        return ab.getAllReviews();
    }
}
