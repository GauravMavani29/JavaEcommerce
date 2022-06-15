/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;

/**
 *
 * @author RUBYSTA JEWELS
 */
@WebFilter(filterName = "UserAuth", urlPatterns = {"/faces/user/cart.xhtml"})
public class UserAuth implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public UserAuth() {
    }
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        if(((HttpServletRequest) request).getSession().getAttribute("user") != null){
            chain.doFilter(request, response);
        }else{
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();
            Users user = (Users) session.getAttribute("user");
            ((HttpServletResponse) response).sendRedirect("/EcommerceProject/faces/login.xhtml");
        }
    }
    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }
}
