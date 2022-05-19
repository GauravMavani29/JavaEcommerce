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
public interface AdminbeanLocal {
      // User 
    Collection<Users> getAllUsers();
    void addUser(String name, String email, String password, String address, String phone, Integer pincode);
    void updateUser(Integer id, String name, String email, String password, String address, String phone, Integer pincode);
    void removeUser(Integer id);
    
      // Group 
    Collection<Groups> getAllGroups();
    void addGroup(String group_name, Integer user_id);
    void updateGroup(Integer id, String group_name, Integer user_id);
    void removeGroup(Integer id, Integer user_id);
    
      // Brand 
    Collection<Brands> getAllBrands();
    void addBrand(String name);
    void updateBrand(Integer id ,String name);
    void removeBrand(Integer id); 
    
     // Category
    Collection<Categories> getAllCategories();
    void addCategory(String name, String image, String meta_title, String meta_description);
    void updateCategory(Integer id ,String name, String image, String meta_title, String meta_description);
    void removeCategory(Integer id); 
    
     // Setting
    Collection<Settings> getAllSettings();
    void addSetting(String sitemaplink, String keyword, String author, String description);
    void updateSetting(Integer id ,String sitemaplink, String keyword, String author, String description);
    void removeSetting(Integer id); 
    
     // Banner
    Collection<Banners> getAllBanners();
    void addBanner(String title, String description, String link, String image,Integer is_active);
    void updateBanner(Integer id ,String title, String description, String link, String image,Integer is_active);
    void removeBanner(Integer id); 
    
     // Product
    Collection<Products> getAllProducts();
    void addProduct(Integer category_id, Integer brand_id, String name, String slug, String description, String image, Integer qty, Integer price, Integer club_points, String meta_title, String meta_description, Integer is_feature, Integer is_active);
    void updateProduct(Integer id ,Integer category_id, Integer brand_id, String name, String slug, String description, String image, Integer qty, Integer price, Integer club_points, String meta_title, String meta_description, Integer is_feature, Integer is_active);
    void removeProduct(Integer id,Integer category_id, Integer brand_id); 
    
     // Order
    Collection<Orders> getAllOrders();
    void removeOrder(Integer id); 
    
     // OrderDetail
    Collection<OrderDetails> getAllOrderDetails();
    
     // Payment
     Collection<Payments> getAllPayments();
     
     // Review
    Collection<Reviews> getAllReviews();
    void updateReview(Integer id ,Integer rating, String description);
    void removeReview(Integer id); 
    
    void addOrderDetail(Integer order_no_details, Integer product_id, Integer total);
}
