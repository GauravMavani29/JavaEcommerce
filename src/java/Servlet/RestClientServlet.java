/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import beans.AdminbeanLocal;
import client.RestClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import models.Banners;
import models.Brands;
import models.Categories;
import models.Groups;
import models.OrderDetails;
import models.Orders;
import models.Products;
import models.Settings;
import models.Users;

/**
 *
 * @author RUBYSTA JEWELS
 */
@WebServlet(name = "RestClientServlet", urlPatterns = {"/RestClientServlet"})
public class RestClientServlet extends HttpServlet {
    
    RestClient rc;
    @EJB AdminbeanLocal ecm;
    Response res;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rc = new RestClient();
            
        response.setContentType("text/html;charset=UTF-8");
        
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RestClientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
//            rc.addUser("Gaurav","gauravmavani29@gmail.com","123456","Surat", "1234567890","395006");
//            rc.addUser("Urvesh","urvesh@gmail.com","123456","Vadodara", "1234567890","395006");
//            rc.addUser("Artik","artik@gmail.com","123456","Canada", "1234567890","395006");
//            rc.updateUser("10","111","1111","111","dfgfwe","2121","212121");
//            rc.removeUser("10");
//            Colection<Users> user;
            GenericType<Collection<Users>> guser = new GenericType<Collection<Users>>(){};
            res = rc.getAllUsers(Response.class);
            
            Collection<Users> users = res.readEntity(guser);
            out.println("<center>");
            out.println("<h1>Users List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Address</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Pincode</th>");
            out.println("<th>ClubPoints</th>");
            out.println("<th>IsActive</th>");
            out.println("</tr>");

            for(Users s : users){
                out.println("<tr>");
                out.println("<td>" + s.getName()+ "</td>"); 
                out.println("<td>" + s.getEmail()+ "</td>"); 
                out.println("<td>" + s.getAddress()+ "</td>"); 
                out.println("<td>" + s.getPhone()+ "</td>"); 
                out.println("<td>" + s.getPincode()+ "</td>"); 
                out.println("<td>" + s.getClubpoints()+ "</td>"); 
                out.println("<td>" + s.getIsActive()+ "</td>"); 
                out.println("</tr>");
            }   
            
            out.println("</table>");
            
//            rc.addGroup("admin","47");
//            rc.addGroup("customer","48");
//            rc.addGroup("customer","49");
            GenericType<Collection<Groups>> ggroup = new GenericType<Collection<Groups>>(){};
            
            res = rc.getAllGroups(Response.class);
            
            Collection<Groups> groups = res.readEntity(ggroup);
            
            
            out.println("<h1>Groups List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>User</th>");
            out.println("</tr>");

            for(Groups s : groups){
                out.println("<tr>");
                out.println("<td>" + s.getGroupName()+ "</td>"); 
                out.println("<td>" + s.getUserId().getName()+ "</td>"); 
                out.println("</tr>");
            }      
            
            out.println("</table>");
            
//            rc.addBanner("Title1", "Description1", "Link1", "Image1","1");
//            rc.addBanner("Title2", "Description2", "Link2", "Image2","1");
//            rc.addBanner("Title3", "Description3", "Link3", "Image3","0");
            
            GenericType<Collection<Banners>> gbanner = new GenericType<Collection<Banners>>(){};
            
            res = rc.getAllBanners(Response.class);
            
            Collection<Banners> banners = res.readEntity(gbanner);
            
            out.println("<h1>Banners List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Sitemap</th>");
            out.println("<th>Keyword</th>");    
            out.println("<th>Author</th>");  
            out.println("<th>Description</th>"); 
            out.println("</tr>");

            for(Banners s : banners){
                out.println("<tr>");
                out.println("<td>" + s.getTitle()+ "</td>");
                out.println("<td>" + s.getDescription()+ "</td>");   
                out.println("<td>" + s.getLink()+ "</td>");   
                out.println("<td>" + s.getImage()+ "</td>");   
                out.println("</tr>");
            }
            out.println("</table>");
            
            
//            ecm.addSetting("ecommerce.com", "SEO keyword", "Site Author", "SEO description");

            GenericType<Collection<Settings>> gsetting = new GenericType<Collection<Settings>>(){};
            
            res = rc.getAllSettings(Response.class);
            
            Collection<Settings> settings = res.readEntity(gsetting);
            
            
            out.println("<h1>Setting List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Sitemap</th>");
            out.println("<th>Keyword</th>");    
            out.println("<th>Author</th>");  
            out.println("<th>Description</th>"); 
            out.println("</tr>");

            for(Settings s : settings){
                out.println("<tr>");
                out.println("<td>" + s.getSitemapLink()+ "</td>");
                out.println("<td>" + s.getKeyword()+ "</td>");   
                out.println("<td>" + s.getAuthor() + "</td>");   
                out.println("<td>" + s.getDescription()+ "</td>");   
                out.println("</tr>");
            }
            
            out.println("</table>");
//            rc.addBrand("Samsung");
//            rc.addBrand("Apple");
//            rc.addBrand("MI");
            
            
            GenericType<Collection<Brands>> gbrand = new GenericType<Collection<Brands>>(){};
            
            res = rc.getAllBrands(Response.class);
            
            Collection<Brands> brands = res.readEntity(gbrand);
            
            out.println("<h1>Brands List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("</tr>");

            for(Brands s : brands){
                out.println("<tr>");
                out.println("<td>" + s.getName()+ "</td>"); 
                out.println("</tr>");
            }           
            out.println("</table>");
            
            
//            rc.addCategory("Smart Phone","Image1","metatitle1","metadescription1");
//            rc.addCategory("Earphone","Image2","metatitle2","metadescription2");
//            rc.addCategory("Watch","Image3","metatitle3","metadescription3");
            
            GenericType<Collection<Categories>> gcategory = new GenericType<Collection<Categories>>(){};
            
            res = rc.getAllCategories(Response.class);
            
            Collection<Categories> categories = res.readEntity(gcategory);
            
            out.println("<h1>Categories List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>Image</th>");
            out.println("<th>MetaTitle</th>");
            out.println("<th>MetaDescription</th>");
            out.println("</tr>");

            for(Categories s : categories){
                out.println("<tr>");
                out.println("<td>" + s.getName()+ "</td>"); 
                out.println("<td>" + s.getImage()+ "</td>"); 
                out.println("<td>" + s.getMetaTitle()+ "</td>"); 
                out.println("<td>" + s.getMetaDescription()+ "</td>"); 
                out.println("</tr>");
            }        
            
            out.println("</table>");
            
//            rc.addProduct("11", "7", "F62", "slug1", "product_decription1", "productimage1", "1", "25000", "1000", "metatitle1", "metadescription1", "1", "1");
//            rc.addProduct("12", "8", "13PRO", "slug2", "product_decription2", "productimage2", "3", "50000", "2500", "metatitle2", "metadescription2", "1", "1");
//            rc.addProduct("13", "9", "Note10", "slug3", "product_decription3", "productimage3", "2", "20000", "800", "metatitle3", "metadescription3", "1", "1");
            
            GenericType<Collection<Products>> gproduct = new GenericType<Collection<Products>>(){};
            
            res = rc.getAllProducts(Response.class);
            
            Collection<Products> products = res.readEntity(gproduct);
            
            out.println("<h1>Products List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Category</th>");
            out.println("<th>Brand</th>");
            out.println("<th>Name</th>");
            out.println("<th>Slug</th>");
            out.println("<th>Description</th>");
            out.println("<th>Image</th>");
            out.println("<th>Qty</th>");
            out.println("<th>Price</th>");
            out.println("<th>ClubPoints</th>");
            out.println("<th>Meta_Title</th>");
            out.println("<th>Meta_Description</th>");
            out.println("<th>IsFeature</th>");
            out.println("<th>IsActive</th>");
            out.println("</tr>");

            for(Products s : products){
                out.println("<tr>");
                out.println("<td>" + s.getCategoryId().getName()+ "</td>"); 
                out.println("<td>" + s.getBrandId().getName()+ "</td>"); 
                out.println("<td>" + s.getName()+ "</td>"); 
                out.println("<td>" + s.getSlug()+ "</td>"); 
                out.println("<td>" + s.getDescription()+ "</td>"); 
                out.println("<td>" + s.getImage()+ "</td>"); 
                out.println("<td>" + s.getQty()+ "</td>"); 
                out.println("<td>" + s.getPrice()+ "</td>"); 
                out.println("<td>" + s.getClubPoints()+ "</td>"); 
                out.println("<td>" + s.getMetaTitle()+ "</td>"); 
                out.println("<td>" + s.getMetaDescription()+ "</td>"); 
                out.println("<td>" + s.getIsFeature()+ "</td>"); 
                out.println("<td>" + s.getIsActive()+ "</td>"); 
                out.println("</tr>");
            }        
            
            out.println("</table>");
            
            rc.addOrder("123456","48","Artik","Surat","395006");
            rc.addOrderDetail("123456", "1", "1200");
            rc.addPayment("123456", "1200", "Paypal");
            
            GenericType<Collection<OrderDetails>> gorder = new GenericType<Collection<OrderDetails>>(){};
            
            res = rc.getAllOrderDetails(Response.class);
            
            Collection<OrderDetails> orders = res.readEntity(gorder);
            
            out.println("<h1>Orders List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>OrderNo</th>");
            out.println("<th>CustomerId</th>");
            out.println("<th>ProductName</th>");
            out.println("<th>CustomerName</th>");
            out.println("<th>Address</th>");
            out.println("<th>Pincode</th>");
            out.println("<th>OrderDate</th>");
            out.println("<th>Amount</th>");
            out.println("</tr>");

            for(OrderDetails s : orders){
                out.println("<tr>");
                out.println("<td>" + s.getOrderNo()+ "</td>"); 
                out.println("<td>" + s.getOrderNo().getUserId()+ "</td>"); 
                out.println("<td>" + s.getOrderNo().getName()+ "</td>"); 
                out.println("<td>" + s.getProductId().getName()+ "</td>"); 
                out.println("<td>" + s.getOrderNo().getAddress()+ "</td>"); 
                out.println("<td>" + s.getOrderNo().getPincode()+ "</td>"); 
                out.println("<td>" + s.getOrderNo().getOrderDate()+ "</td>"); 
                out.println("<td>" + s.getTotal()+ "</td>"); 
                out.println("</tr>");
            }        
            
            out.println("</table>");
            
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
