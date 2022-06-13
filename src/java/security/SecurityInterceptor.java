/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package security;


import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import record.KeepRecord;


/**
 *
 * @author root
 */
@Named
@RequestScoped
public class SecurityInterceptor implements HttpAuthenticationMechanism, Serializable {

    @Inject IdentityStoreHandler handler;
    CredentialValidationResult result;
    AuthenticationStatus status;
    
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext ctx) throws AuthenticationException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
       
       if(request.getRequestURI().contains("logout"))
       {
           try{
           request.logout();
        //   request.getSession().invalidate();
             KeepRecord.reset();
           response.sendRedirect("index.xhtml");
           return ctx.doNothing();
           }
           catch(Exception x)
           {
               return ctx.doNothing();
           }
       }
       
      if(request.getParameter("username")!=null) 
      {
           try{ 
          String username = request.getParameter("username");
          String password = request.getParameter("password");
         Credential credential = new UsernamePasswordCredential(username, new Password(password)); 
         result = handler.validate(credential);
       
         
         if(result.getStatus()== Status.VALID)
         {
             
             KeepRecord.setPrincipal(result.getCallerPrincipal());
             KeepRecord.setRoles(result.getCallerGroups());
             // Getting Authentication Status
            status = ctx.notifyContainerAboutLogin(result);
            
            request.setAttribute("user", result.getCallerPrincipal().getName());
             
             if(result.getCallerGroups().contains("Admin"))
             {
                 request.getRequestDispatcher("/admin/dashboard.xhtml").forward(request, response);
                 return status;
             }
             else if(result.getCallerGroups().contains("Customer"))
             {
                 request.getRequestDispatcher("/index.xhtml").forward(request, response);
                 return status;
             }
             
         }
         else
         {
             request.setAttribute("error", "Either Username or Password is wrong !!");
             System.out.println("dsadasdsad");
                request.getRequestDispatcher("/login.xhtml").forward(request, response);
              return ctx.doNothing();
         
         }
         
          
         }
   catch(Exception e)
   {
     return  ctx.doNothing();
   }
      }
      
       if(KeepRecord.getPrincipal()!=null)
       {
           status = ctx.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
           return status;
       }
       
   
    return ctx.doNothing();
    }
   
    
    
}
