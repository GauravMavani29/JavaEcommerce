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
import models.Banners;

/**
 *
 * @author RUBYSTA JEWELS
 */
@WebServlet(name = "BannersServlet", urlPatterns = {"/BannersServlet"})
public class BannersServlet extends HttpServlet {
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
            out.println("<title>Servlet BannersServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//          ecm.removeBanner(1);
//          ecm.addBanner("dasd", "dasdsd", "dsadsd", "dsadsd",1);
//          ecm.updateBanner(2, "dasd3232", "dasdsd3232", "dsadsd323", "dasds323", 1);

            out.println("<h1>Banners List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Sitemap</th>");
            out.println("<th>Keyword</th>");    
            out.println("<th>Author</th>");  
            out.println("<th>Description</th>"); 
            out.println("</tr>");

            Collection<Banners> banners = ecm.getAllBanners();
            for(Banners s : banners){
                out.println("<tr>");
                out.println("<td>" + s.getTitle()+ "</td>");
                out.println("<td>" + s.getDescription()+ "</td>");   
                out.println("<td>" + s.getLink()+ "</td>");   
                out.println("<td>" + s.getImage()+ "</td>");   
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
