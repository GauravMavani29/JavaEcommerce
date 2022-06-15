/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsfbeans.userside;

import beans.AdminbeanLocal;
import beans.UserbeanLocal;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import models.Categories;
import models.Products;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Named(value = "general")
@ApplicationScoped
public class general {

    @EJB
    private UserbeanLocal ub;
    
    private Collection<Products> latestProducts;
    private Collection<Categories> categorylist;
    
    @PostConstruct
    public void init(){
        latestProducts = ub.getlatestProduct();
        categorylist = ub.getAllCategories();
    }

        
    public general() {
    }
    
    public Collection<Products> getLatestProducts() {
        return latestProducts;
    }

    public void setLatestProducts(Collection<Products> latestProducts) {
        this.latestProducts = latestProducts;
    }

    public Collection<Categories> getCategorylist() {
        return categorylist;
    }

    public void setgetCategorylist(Collection<Categories> categories) {
        this.categorylist = categories;
    }

}
