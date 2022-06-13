/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import beans.AdminbeanLocal;
import beans.UserbeanLocal;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import models.Banners;
import models.Brands;
import models.Carts;
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
 * REST Web Service
 *
 * @author RUBYSTA JEWELS
 */
@Path("/ecommerceapi/")
public class EcommerceapiResource {

    @Context
    private UriInfo context;
    @EJB
    AdminbeanLocal admin;
    UserbeanLocal user;

    /**
     * Creates a new instance of EcommerceapiResource
     */
    public EcommerceapiResource() {
    }

    //Users
    @GET
    @Path("getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Users> getAllUsers() {
        return admin.getAllUsers();
    }

    @POST
    @Path("addUser/{name}/{email}/{password}/{address}/{phone}/{pincode}")
    public void addUser(@PathParam("name") String name, @PathParam("email") String email, @PathParam("password") String password, @PathParam("address") String address, @PathParam("phone") String phone, @PathParam("pincode") Integer pincode) {
        admin.addUser(name, email, password, address, phone, pincode);
    }

    @PUT
    @Path("updateUser/{id}/{name}/{email}/{password}/{address}/{phone}/{pincode}")
    public void updateUser(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("email") String email, @PathParam("password") String password, @PathParam("address") String address, @PathParam("phone") String phone, @PathParam("pincode") Integer pincode) {
        admin.updateUser(id, name, email, password, address, phone, pincode);
    }

    @DELETE
    @Path("removeUser/{id}")
    public void removeUser(@PathParam("id") Integer id) {
        admin.removeUser(id);
    }

    //Groups
    @GET
    @Path("getAllGroups")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Groups> getAllGroups() {
        return admin.getAllGroups();
    }

    @POST
    @Path("addUser/{groups_name}/{user_id}")
    public void addGroup(@PathParam("groups_name") String group_name, @PathParam("user_id") Integer user_id) {
        admin.addGroup(group_name, user_id);
    }

    @PUT
    @Path("updateGroup/{id}/{groups_name}/{user_id}")
    public void updateGroup(@PathParam("id") Integer id, @PathParam("groups_name") String group_name, @PathParam("user_id") Integer user_id) {
        admin.updateGroup(id, group_name, user_id);
    }

    @DELETE
    @Path("removeGroup/{id}/{user_id}")
    public void removeGroup(@PathParam("id") Integer id, @PathParam("user_id") Integer user_id) {
        admin.removeGroup(id, user_id);
    }

    //Brands
    @GET
    @Path("getAllBrands")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Brands> getAllBrands() {
        return admin.getAllBrands();
    }

    @POST
    @Path("addBrand/{name}")
    public void addBrand(@PathParam("name") String name) {
        admin.addBrand(name);
    }

    @PUT
    @Path("updateBrand/{id}/{groups_name}/{user_id}")
    public void updateBrand(@PathParam("groups_name") Integer id, @PathParam("user_id") String name) {
        admin.updateBrand(id, name);
    }

    @DELETE
    @Path("removeGroup/{id}")
    public void removeBrand(@PathParam("id") Integer id) {
        admin.removeBrand(id);
    }

    //Categories
    @GET
    @Path("getAllCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Categories> getAllCategories() {
        return admin.getAllCategories();
    }

    @POST
    @Path("addCategory/{name}/{image}/{meta_title}/{meta_description}")
    public void addCategory(@PathParam("name") String name, @PathParam("image") String image, @PathParam("meta_title") String meta_title, @PathParam("meta_description") String meta_description) {
        admin.addCategory(name, image, meta_title, meta_description);
    }

    @PUT
    @Path("updateCategory/{id}/{name}/{image}/{meta_title}/{meta_description}")
    public void updateCategory(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("image") String image, @PathParam("meta_title") String meta_title, @PathParam("meta_description") String meta_description) {
        admin.updateCategory(id, name, image, meta_title, meta_description);
    }

    @DELETE
    @Path("removeCategory/{id}")
    public void removeCategory(@PathParam("id") Integer id) {
        admin.removeCategory(id);
    }

    //Settings
    @GET
    @Path("getAllSettings")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Settings> getAllSettings() {
        return admin.getAllSettings();
    }

    @POST
    @Path("addSetting/{sitemaplink}/{keyword}/{author}/{description}")
    public void addSetting(@PathParam("sitemaplink") String sitemaplink, @PathParam("keyword") String keyword, @PathParam("author") String author, @PathParam("description") String description) {
        admin.addSetting(sitemaplink, keyword, author, description);
    }

    @PUT
    @Path("updateSetting/{id}/{sitemaplink}/{keyword}/{author}/{description}")
    public void updateSetting(@PathParam("id") Integer id, @PathParam("sitemaplink") String sitemaplink, @PathParam("keyword") String keyword, @PathParam("author") String author, @PathParam("description") String description) {
        admin.updateSetting(id, sitemaplink, keyword, author, description);
    }

    @DELETE
    @Path("removeSetting/{id}")
    public void removeSetting(@PathParam("id")Integer id) {
        admin.removeSetting(id);
    }

    //Banner
    @GET
    @Path("getAllBanners")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Banners> getAllBanners() {
        return admin.getAllBanners();
    }

    @POST
    @Path("addBanner/{title}/{description}/{link}/{image}/{is_active}")
    public void addBanner(@PathParam("title") String title, @PathParam("description") String description, @PathParam("link") String link, @PathParam("image") String image, @PathParam("is_active") Integer is_active) {
        admin.addBanner(title, description, link, image, is_active);
    }

    @PUT
    @Path("updateBanner/{id}/{title}/{description}/{link}/{image}/{is_active}")
    public void updateBanner(@PathParam("id") Integer id, @PathParam("title") String title, @PathParam("description") String description, @PathParam("link") String link, @PathParam("image") String image, @PathParam("is_active") Integer is_active) {
        admin.updateBanner(id, title, description, link, image, is_active);
    }

    @DELETE
    @Path("removeBanner/{id}")
    public void removeBanner(@PathParam("id")Integer id) {
        admin.removeBanner(id);
    }
    
    
    //Product
    @GET
    @Path("getAllProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Products> getAllProducts() {
        return admin.getAllProducts();
    }

    @POST
    @Path("addProduct/{category_id}/{brand_id}/{name}/{slug}/{description}/{image}/{qty}/{price}/{club_points}/{meta_title}/{meta_description}/{is_feature}/{is_active}")
  public void addProduct(@PathParam("category_id")Integer category_id, @PathParam("brand_id")Integer brand_id, @PathParam("name")String name, @PathParam("slug")String slug, @PathParam("description")String description, @PathParam("image")String image, @PathParam("qty")Integer qty, @PathParam("price")Integer price, @PathParam("club_points")Integer club_points, @PathParam("meta_title")String meta_title, @PathParam("meta_description")String meta_description, @PathParam("is_feature")Integer is_feature, @PathParam("is_active")Integer is_active) {
        admin.addProduct(category_id, brand_id, name, slug, description, image, qty, price, club_points, meta_title, meta_description, is_feature, is_active);
    }

    @PUT
    @Path("updateBanner/{id}/{category_id}/{brand_id}/{name}/{slug}/{description}/{image}/{qty}/{price}/{club_points}/{meta_title}/{meta_description}/{is_feature}/{is_active}")
    public void updateProduct(@PathParam("id")Integer id, @PathParam("category_id")Integer category_id, @PathParam("brand_id")Integer brand_id, @PathParam("name")String name, @PathParam("slug")String slug, @PathParam("description")String description, @PathParam("image")String image, @PathParam("qty")Integer qty, @PathParam("price")Integer price, @PathParam("club_points")Integer club_points, @PathParam("meta_title")String meta_title, @PathParam("meta_description")String meta_description, @PathParam("is_feature")Integer is_feature, @PathParam("is_active")Integer is_active) {
        admin.updateProduct(id, category_id, brand_id, name, slug, description, image, qty, price, club_points, meta_title, meta_description, is_feature, is_active);
    }

    @DELETE
    @Path("removeProduct/{id}/{category_id}/{brand_id}")
    public void removeProduct(@PathParam("id")Integer id, @PathParam("category_id")Integer category_id, @PathParam("brand_id")Integer brand_id) {   
        admin.removeProduct(id,category_id,brand_id);
    }
    
    
    //Order
    @GET
    @Path("getAllOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Orders> getAllOrders() {
        return admin.getAllOrders();
    }
    
    @DELETE
    @Path("removeOrder/{id}")
    public void removeOrder(@PathParam("id")Integer id) {
        admin.removeOrder(id);
    }
    
    
    //OrderDetails
    @GET
    @Path("getAllOrderDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderDetails> getAllOrderDetails() {
        return admin.getAllOrderDetails();
    }
    
    
    //PaymentDetails
    @GET
    @Path("getAllPayments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Payments> getAllPayments() {
        return admin.getAllPayments();
    }
    
    //Reviews
    @GET
    @Path("getAllReviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Reviews> getAllReviews() {
        return admin.getAllReviews();
    }
    
    @PUT
    @Path("updateReview/{id}/{rating}/{description}")
     public void updateReview(@PathParam("id")Integer id, @PathParam("rating")Integer rating, @PathParam("description")String description) {
        admin.updateReview(id, rating, description);
    }
     
    @DELETE
    @Path("removeReview/{id}")
     public void removeReview(@PathParam("id")Integer id) {
        admin.removeReview(id);
    }
     
     
    //UserSide
     
    @GET
    @Path("getUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
     public Users getUser(@PathParam("id")Integer id) {
       return  user.getUser(id);
    }
     
    
    //Display Products
    @GET
    @Path("userProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Products> userProducts() {
        return user.userProducts();
    }
    
    
    //UserCart
    @GET
    @Path("userCarts/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Carts> userCarts(@PathParam("user_id")Users user_id) {
        return user.userCarts(user_id);
    }
    
    //AddUserOrder
    @POST
    @Path("addOrder/{order_no}/{user_id}/{name}/{address}/{pincode}")
    public void addOrder(@PathParam("order_no")Integer order_no, @PathParam("user_id")Integer user_id, @PathParam("name")String name, @PathParam("address")String address, @PathParam("pincode")Integer pincode) {
        user.addOrder(order_no, user_id, name, address, pincode);
    }
    
    //AddUserOrderDetails
    @POST
    @Path("addOrderDetail/{order_no}/{product_id}/{total}")
    public void addOrderDetail(@PathParam("order_no")Integer order_no, @PathParam("product_id")Integer product_id, @PathParam("total")Integer total) {
//        user.addOrderDetail(order_no, product_id, total);
    }
    
    //AddUserOrderPayment
    @POST
    @Path("addPayment/{order_no}/{amount}/{method}")
    public void addPayment(@PathParam("order_no")Integer order_no, @PathParam("amount")Integer amount, @PathParam("method")String method) {
        user.addPayment(order_no, amount, method);
    }
    
    
    
    //UserOrders
    @GET
    @Path("userOrders/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Orders> userOrders(@PathParam("user_id")Users user_id) {
        return user.userOrders(user_id);
    }
    
    //UserReviews
    @GET
    @Path("productReviews/{product_id}")
    @Produces(MediaType.APPLICATION_JSON)
     public Collection<Reviews> productReviews(@PathParam("product_id")Products product_id){
        return user.productReviews(product_id);
    }
     
}