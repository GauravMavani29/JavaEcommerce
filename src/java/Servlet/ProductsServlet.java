/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import beans.AdminbeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Products;

/**
 *
 * @author RUBYSTA JEWELS
 */
@WebServlet(name = "ProductsServlet", urlPatterns = {"/ProductsServlet"})
public class ProductsServlet extends HttpServlet {
 @EJB AdminbeanLocal ecm;

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            Collection<Products> products = ecm.getAllProducts();
            
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
