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
import models.Banners;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Named(value = "home")
@ApplicationScoped
public class home {
    
    @EJB
    private UserbeanLocal ub;
    private Collection<Banners> banners;
    
    @PostConstruct
    public void init(){
        banners = ub.getactiveBanner();
    }
    
    public home() {
    }

    public Collection<Banners> getBanners() {
        return banners;
    }

    public void setBanners(Collection<Banners> banners) {
        this.banners = banners;
    }
    
}
