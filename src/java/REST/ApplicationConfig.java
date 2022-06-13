/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package REST;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author RUBYSTA JEWELS
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(REST.EcommerceapiResource.class);
        resources.add(models.service.BrandsFacadeREST.class);
        resources.add(models.service.CartsFacadeREST.class);
        resources.add(models.service.CategoriesFacadeREST.class);
        resources.add(models.service.GroupsFacadeREST.class);
        resources.add(models.service.OrderDetailsFacadeREST.class);
        resources.add(models.service.OrdersFacadeREST.class);
        resources.add(models.service.PaymentsFacadeREST.class);
        resources.add(models.service.ProductsFacadeREST.class);
        resources.add(models.service.ReviewsFacadeREST.class);
        resources.add(models.service.UsersFacadeREST.class);
    }
    
}
