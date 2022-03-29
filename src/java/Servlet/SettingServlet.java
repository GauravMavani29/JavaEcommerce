/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import beans.AdminbeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Settings;
/**
 *
 * @author RUBYSTA JEWELS
 */
import java.util.Date;
@WebServlet(name = "SettingServlet", urlPatterns = {"/SettingServlet"})
public class SettingServlet extends HttpServlet {
    
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
            out.println("<title>Servlet SettingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//          ecm.removeSetting(1);
//          ecm.addSetting("dasd", "dasdsd", "dsadsd", "dasds");
//          ecm.updateSetting(28, "dasd3232", "dasdsd3232", "dsadsd323", "dasds323");

            out.println("<h1>Setting List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>Sitemap</th>");
            out.println("<th>Keyword</th>");    
            out.println("<th>Author</th>");  
            out.println("<th>Description</th>"); 
            out.println("</tr>");

            Collection<Settings> settings = ecm.getAllSettings();
            for(Settings s : settings){
                out.println("<tr>");
                out.println("<td>" + s.getSitemapLink()+ "</td>");
                out.println("<td>" + s.getKeyword()+ "</td>");   
                out.println("<td>" + s.getAuthor() + "</td>");   
                out.println("<td>" + s.getAuthor()+ "</td>");   
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
