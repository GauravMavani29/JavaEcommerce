/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsfbeans.userside;

import beans.UserbeanLocal;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.Banners;
import models.Carts;
import models.Products;
import models.Users;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Named(value = "shop")
@ApplicationScoped
public class shop {

   @EJB
    private UserbeanLocal ub;
    private Collection<Products> productlist;
    private Collection<Carts> cartlist;
    private int qty = 1;
    private int total = 0;
    private String cartError = "";

  
    private Collection<Products> relatedProducts;
    private Products product;
    
    @PostConstruct
    public void init(){
        productlist = ub.userProducts();
        getCartList();
    }
    
    public shop() {
    }
    
    public String productDetail(Products p){
        this.product = p;
        this.relatedProducts = p.getCategoryId().getProductsCollection();
        return "/user/productdetail.xhtml?faces-redirect=true";
    }
    
    public String addToCart(Products p)throws IOException{
        product = p;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users u = (Users) session.getAttribute("user");
        if(u == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/EcommerceProject/faces/login.xhtml");
        }
        total = product.getPrice() * qty;
        int status = ub.addToCart(product.getId(), u.getId(),qty , total);
         getCartList();
        if(status == 1){
            System.out.println("product already exist");
            qty = 1;
            cartError = "product already into cart";
            return null;
        }else{
            cartError = "";
             qty = 1;
             FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/EcommerceProject/faces/user/cart.xhtml");
             return null;
        }
    }

     public String removeCart(int cid){
        ub.removeCart(cid);
         getCartList();
        return "/user/cart.xhtml?faces-redirect=true";
    }
     
     public void getCartList(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Users u = (Users) session.getAttribute("user");
        cartlist = ub.userCarts(u);
     }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Collection<Products> getProductlist() {
        return productlist;
    }

    public void setProductlist(Collection<Products> banners) {
        this.productlist = banners;
    }
      public Collection<Products> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(Collection<Products> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCartError() {
        return cartError;
    }

    public void setCartError(String cartError) {
        this.cartError = cartError;
    }
    
     public Collection<Carts> getCartlist() {
        return cartlist;
    }

    public void setCartlist(Collection<Carts> cartlist) {
        this.cartlist = cartlist;
    }
    
}
