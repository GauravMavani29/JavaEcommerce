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
import models.Users;

/**
 *
 * @author RUBYSTA JEWELS
 */
@WebServlet(name = "UsersServlet", urlPatterns = {"/UsersServlet"})
public class UsersServlet extends HttpServlet {
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
            out.println("<title>Servlet UsersServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//            ecm.removeUser(1);
//            ecm.addUser("dasd","dasd","dasd","dfgfwe",(double)1212,020202);
//            ecm.updateUser(2,"dasd","dasd","dasd","dfgfwe",(double)1000,02222);

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

            Collection<Users> users = ecm.getAllUsers();
            for(Users s : users){
                out.println("<tr>");
                out.println("<td>" + s.getName()+ "</td>"); 
                out.println("<td>" + s.getEmail()+ "</td>"); 
                out.println("<td>" + s.getAddress()+ "</td>"); 
                out.println("<td>" + s.getPhone()+ "</td>"); 
                 out.println("<td>" +  s.getPincode()+ "</td>"); 
                  out.println("<td>" + s.getClubpoints()+ "</td>"); 
                   out.println("<td>" + s.getIsActive()+ "</td>"); 
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