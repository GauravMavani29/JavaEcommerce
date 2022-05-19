/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import beans.AdminbeanLocal;
import beans.UserbeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.OrderDetails;
import models.Orders;

/**
 *
 * @author RUBYSTA JEWELS
 */
@WebServlet(name = "OrdersServlet", urlPatterns = {"/OrdersServlet"})
public class OrdersServlet extends HttpServlet {
 @EJB UserbeanLocal ecm;
 @EJB AdminbeanLocal aecm;

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
            out.println("<title>Servlet OrdersServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//            ecm.addOrder(123456, 48, "Urvesh", "Surat", 395006);
            aecm.addOrderDetail(12, 1, 1200);
            ecm.addPayment(12, 1200, "Paypal");
            Collection<OrderDetails> orders = aecm.getAllOrderDetails();
            out.println("<h1>Orders List</h1>");
            out.println("<table border='1px' width='400' height='250'>");
            out.println("<tr>");
            out.println("<th>OrderNo</th>");
            out.println("<th>ProductName</th>");
            out.println("<th>CustomerName</th>");
            out.println("<th>Address</th>");
            out.println("<th>Pincode</th>");
            out.println("<th>OrderDate</th>");
            out.println("<th>Amount</th>");
            out.println("</tr>");

            for(OrderDetails s : orders){
                out.println("<tr>");
                out.println("<td>" + s.getOrderNoDetails().getOrderNo()+ "</td>"); 
                out.println("<td>" + s.getProductId().getName()+ "</td>"); 
                out.println("<td>" + s.getOrderNoDetails().getName()+ "</td>"); 
                out.println("<td>" + s.getOrderNoDetails().getAddress()+ "</td>"); 
                out.println("<td>" + s.getOrderNoDetails().getPincode()+ "</td>"); 
                out.println("<td>" + s.getOrderNoDetails().getOrderDate()+ "</td>"); 
                out.println("<td>" + s.getTotal()+ "</td>"); 
                out.println("</tr>");
            }        
            
            out.println("</table>");
            
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
