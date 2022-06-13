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
import models.Categories;

/**
 *
 * @author RUBYSTA JEWELS
 */
@WebServlet(name = "CategoriesServlet", urlPatterns = {"/CategoriesServlet"})
public class CategoriesServlet extends HttpServlet {
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
            out.println("<title>Servlet CategoriesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//            ecm.removeCategory(1);
//            ecm.addCategory("dasd","dasd","dasd","dfgfwe");
//            ecm.updateCategory(2,"dasd","dasd","dasd","dfgf342we");

            out.println("<h1>Categories List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>Image</th>");
            out.println("<th>MetaTitle</th>");
            out.println("<th>MetaDescription</th>");
            out.println("</tr>");

            Collection<Categories> categories = ecm.getAllCategories();
            for(Categories s : categories){
                out.println("<tr>");
                out.println("<td>" + s.getName()+ "</td>"); 
                out.println("<td>" + s.getImage()+ "</td>"); 
                out.println("<td>" + s.getMetaTitle()+ "</td>"); 
                out.println("<td>" + s.getMetaDescription()+ "</td>"); 
                out.println("</tr>");
            }        
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