/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package beans;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Banners;
import models.Brands;
import models.Categories;
import models.Groups;
import models.OrderDetails;
import models.Orders;
import models.Payments;
import models.Products;
import models.Reviews;
import models.Settings;
import models.Users;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Stateless
public class Adminbean implements AdminbeanLocal {
    @PersistenceContext(unitName = "EcommerceProjectPU")
    EntityManager em;
    
    @Override
    public Collection<Users> getAllUsers() {
       return em.createNamedQuery("Users.findAll").getResultList();
    }

    @Override
    public void addUser(String name, String email, String password, String address, String phone, Integer pincode) {
        Users u = new Users();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        u.setAddress(address);
        u.setPhone(phone);
        u.setPincode(pincode);
        em.persist(u);
    }

    @Override
    public void updateUser(Integer id, String name, String email, String password, String address, String phone, Integer pincode) {
        Users u = (Users) em.find(Users.class, id);
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        u.setAddress(address);
        u.setPhone(phone);
        u.setPincode(pincode);
        em.merge(u);
    }

    @Override
    public void removeUser(Integer id) {
        Users u = (Users) em.find(Users.class, id);
        em.remove(u);
    }
    
    
    @Override
    public Users getUserByEmailPassword(String email, String password) {
        Users u = (Users) em.createNamedQuery("Users.findByEmailandPassword").setParameter("email", email).setParameter("password", password).getSingleResult();
        if(u == null){
            return null;
        }else{
            return u;
        }
    }
    
    @Override
    public Collection<Groups> getAllGroups() {
       return em.createNamedQuery("Groups.findAll").getResultList();
    }

    @Override
    public void addGroup(String group_name, Integer user_id) {
        Users u =  em.find(Users.class, user_id);
        Collection<Groups> groups = u.getGroupsCollection();
        
        Groups g = new Groups();
        g.setGroupName(group_name);
        g.setUserId(u);
        
        groups.add(g);
        u.setGroupsCollection(groups);
        em.persist(g);
        em.merge(u);
    }

    @Override
    public void updateGroup(Integer id, String group_name, Integer user_id) {
        Groups u =  em.find(Groups.class, id);
        Users c = em.find(Users.class, user_id);
        Collection<Groups> users = c.getGroupsCollection();
        
        if(users.contains(u)){ 
            u.setGroupName(group_name);
            u.setUserId(c);
            em.merge(u);

            users.add(u);
            c.setGroupsCollection(users);
            em.merge(c);
        }
    }

    @Override
    public void removeGroup(Integer id, Integer user_id) {
        Users u = em.find(Users.class, user_id);
        Groups g = em.find(Groups.class, id);
        
        Collection<Groups> user = u.getGroupsCollection();
        
        if(user.contains(g)){
            em.remove(g);
            user.remove(g);
            u.setGroupsCollection(user);
            em.merge(u);
        }
    }

    @Override
    public Collection<Brands> getAllBrands() {
        return em.createNamedQuery("Brands.findAll").getResultList();
    }

    @Override
    public void addBrand(String name) {
        Brands u = new Brands();
        u.setName(name);
        em.persist(u);
    }

    @Override
    public void updateBrand(Integer id, String name) {
        Brands u = (Brands) em.find(Brands.class, id);
        u.setName(name);
        em.merge(u);
    }

    @Override
    public void removeBrand(Integer id) {
        Brands u = (Brands) em.find(Brands.class, id);
        em.remove(u);
    }

    @Override
    public Collection<Categories> getAllCategories() {
        return em.createNamedQuery("Categories.findAll").getResultList();
    }

    @Override
    public void addCategory(String name, String image, String meta_title, String meta_description) {
       Categories u = new Categories();
       u.setName(name);
       u.setImage(image);
       u.setMetaTitle(meta_title);
       u.setMetaDescription(meta_description);
       em.persist(u);
       
    }

    @Override
    public void updateCategory(Integer id, String name, String image, String meta_title, String meta_description) {
       Categories u = (Categories) em.find(Categories.class, id);
       u.setName(name);
       u.setImage(image);
       u.setMetaTitle(meta_title);
       u.setMetaDescription(meta_description);
       em.merge(u);
    }

    @Override
    public void removeCategory(Integer id) {
       Categories u =  em.find(Categories.class, id);
       em.remove(u);
    }

    @Override
    public Collection<Settings> getAllSettings() {
        return em.createNamedQuery("Settings.findAll").getResultList();
    }

    @Override
    public void addSetting(String sitemaplink, String keyword, String author, String description) {
       Settings u = new Settings();
       u.setSitemapLink(sitemaplink);
       u.setKeyword(keyword);
       u.setAuthor(author);
       u.setDescription(description);
       em.persist(u);
    }

    @Override
    public void updateSetting(Integer id, String sitemaplink, String keyword, String author, String description) {
       Settings u = (Settings) em.find(Settings.class, id);
       u.setSitemapLink(sitemaplink);
       u.setKeyword(keyword);
       u.setAuthor(author);
       u.setDescription(description);
       em.merge(u);
    }

    @Override
    public void removeSetting(Integer id) {
       Settings u = (Settings) em.find(Settings.class, id);
       em.remove(u);
    }

    @Override
    public Collection<Banners> getAllBanners() {
       return em.createNamedQuery("Banners.findAll").getResultList();
    }

    @Override
    public void addBanner(String title, String description, String link, String image,Integer is_active) {
       Banners u = new Banners();
       u.setTitle(title);
       u.setDescription(description);
       u.setLink(link);
       u.setImage(image);
       u.setIsActive(is_active);
       em.persist(u);
    }

    @Override
        public void updateBanner(Integer id, String title, String description, String link, String image, Integer is_active) {
       Banners u = (Banners) em.find(Banners.class, id);
       u.setTitle(title);
       u.setDescription(description);
       u.setLink(link);
       u.setImage(image);
       u.setIsActive(is_active);
       em.merge(u);
    }

    @Override
    public void removeBanner(Integer id) {
       Banners u = (Banners) em.find(Banners.class, id);
       em.remove(u);
    }

    @Override
    public Collection<Products> getAllProducts() {
        return em.createNamedQuery("Products.findAll").getResultList();
    }

    @Override
    public void addProduct(Integer category_id, Integer brand_id, String name, String slug, String description, String image, Integer qty, Integer price, Integer club_points, String meta_title, String meta_description, Integer is_feature, Integer is_active) {
       Products u = new Products();
       Categories c = em.find(Categories.class, category_id);
       Brands b = em.find(Brands.class, brand_id);
      
       u.setCategoryId(c);
       u.setBrandId(b);
       u.setName(name);
       u.setSlug(slug);
       u.setDescription(description);
       u.setImage(image);
       u.setQty(qty);
       u.setPrice(price);
       u.setClubPoints(club_points);
       u.setMetaTitle(meta_title);
       u.setMetaDescription(meta_description);
       u.setIsFeature(is_feature);
       u.setIsActive(is_active);
       em.persist(u);
       
       Collection<Products> category = c.getProductsCollection();
       Collection<Products> brand = b.getProductsCollection();
       
       category.add(u);
       c.setProductsCollection(category);
       em.merge(c);
       
       brand.add(u);
       b.setProductsCollection(brand);
       em.merge(b);
       
    }

    @Override
    public void updateProduct(Integer id, Integer category_id, Integer brand_id, String name, String slug, String description, String image, Integer qty, Integer price, Integer club_points, String meta_title, String meta_description, Integer is_feature, Integer is_active) {
       Products u = em.find(Products.class, id);
       Categories c = em.find(Categories.class, category_id);
       Brands b = em.find(Brands.class, brand_id);
       
       Collection<Products> category = c.getProductsCollection();
       Collection<Products> brand = b.getProductsCollection();
      if(category.contains(u) && brand.contains(u)){
        u.setCategoryId(c);
        u.setBrandId(b);
        u.setName(name);
        u.setSlug(slug);
        u.setDescription(description);
        u.setImage(image);
        u.setQty(qty);
        u.setPrice(price);
        u.setClubPoints(club_points);
        u.setMetaTitle(meta_title);
        u.setMetaDescription(meta_description);
        u.setIsFeature(is_feature);
        u.setIsActive(is_active);
        em.merge(u);


        category.add(u);
        c.setProductsCollection(category);
        em.merge(c);

        brand.add(u);
        b.setProductsCollection(brand);
        em.merge(b);
      }
    }

    @Override
    public void removeProduct(Integer id, Integer category_id, Integer brand_id) {    
       Products u =  em.find(Products.class, id);
       Categories c = em.find(Categories.class, category_id);
       Brands b = em.find(Brands.class, brand_id);
       
       Collection<Products> category = c.getProductsCollection();
       Collection<Products> brand = b.getProductsCollection();
       
       if(category.contains(u) && brand.contains(b)){
           em.remove(u);
           category.remove(u);
           c.setProductsCollection(category);
           em.merge(c);   
           brand.remove(u);
           b.setProductsCollection(brand);
           em.merge(b);
       }
    }

    @Override
    public Collection<Orders> getAllOrders() {
        return em.createNamedQuery("Orders.findAll").getResultList();
    }

    @Override
    public void removeOrder(Integer id) {
       Orders u = (Orders) em.find(Orders.class, id);
       em.remove(u);
    }

    @Override
    public Collection<OrderDetails> getAllOrderDetails() {
       return em.createNamedQuery("OrderDetails.findAll").getResultList();
    }

    @Override
    public Collection<Payments> getAllPayments() {
        return em.createNamedQuery("Payments.findAll").getResultList();
    }

    @Override
    public Collection<Reviews> getAllReviews() {
       return em.createNamedQuery("Reviews.findAll").getResultList();
    }

    @Override
    public void updateReview(Integer id, Integer rating, String description) {
       Reviews u = (Reviews) em.find(Reviews.class, id);
       u.setRating(rating);
       u.setDescription(description);
       em.merge(u);
    }

    @Override
    public void removeReview(Integer id) {
       Reviews u = (Reviews) em.find(Reviews.class, id);
       em.remove(u);
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
        
    }

    @Override
    public Brands getBrand(Integer id) {
        return (Brands) em.find(Brands.class, id);
//        Brands b = (Brands) em.createNamedQuery("Brands.findById").setParameter("id", id).getSingleResult();
//        if(b == null){
//            return null;
//        }else{
//            return b;
//        }
    }

    @Override
    public Categories getCategory(Integer id) {
        return (Categories) em.find(Categories.class, id);
    }

    @Override
    public Settings getSetting(Integer id) {
        return (Settings) em.find(Settings.class, id);
    }

    @Override
    public Banners getBanner(Integer id) {
        return (Banners) em.find(Banners.class, id);
    }

    @Override
    public Products getProduct(Integer id) {
        return (Products) em.find(Products.class, id);
    }

}
