/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:EcommerceapiResource
 * [/ecommerceapi/]<br>
 * USAGE:
 * <pre>
 *        RestClient client = new RestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author RUBYSTA JEWELS
 */
public class RestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/EcommerceProject/webresources";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("ecommerceapi");
    }

    public <T> T getAllGroups(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllGroups");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeBanner(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeBanner/{0}", new Object[]{id})).request().delete();
    }

    public void removeBrand(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeGroup/{0}", new Object[]{id})).request().delete();
    }

    public void removeProduct(String id, String category_id, String brand_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeProduct/{0}/{1}/{2}", new Object[]{id, category_id, brand_id})).request().delete();
    }

    public void addProduct(String category_id, String brand_id, String name, String slug, String description, String image, String qty, String price, String club_points, String meta_title, String meta_description, String is_feature, String is_active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addProduct/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{category_id, brand_id, name, slug, description, image, qty, price, club_points, meta_title, meta_description, is_feature, is_active})).request().post(null);
    }

    public void updateProduct(String id, String category_id, String brand_id, String name, String slug, String description, String image, String qty, String price, String club_points, String meta_title, String meta_description, String is_feature, String is_active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateBanner/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}", new Object[]{id, category_id, brand_id, name, slug, description, image, qty, price, club_points, meta_title, meta_description, is_feature, is_active})).request().put(null);
    }

    public void addUser(String name, String email, String password, String address, String phone, String pincode) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{name, email, password, address, phone, pincode})).request().post(null);
    }

    public void updateBrand(String id, String groups_name, String user_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateBrand/{0}/{1}/{2}", new Object[]{id, groups_name, user_id})).request().put(null);
    }

    public void updateCategory(String id, String name, String image, String meta_title, String meta_description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCategory/{0}/{1}/{2}/{3}/{4}", new Object[]{id, name, image, meta_title, meta_description})).request().put(null);
    }

    public <T> T getUser(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUser/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateGroup(String id, String groups_name, String user_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateGroup/{0}/{1}/{2}", new Object[]{id, groups_name, user_id})).request().put(null);
    }

    public <T> T getAllBanners(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllBanners");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllReviews(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllReviews");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUserByEmailPassword(Class<T> responseType, String email, String password) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserByEmailPassword/{0}/{1}", new Object[]{email, password}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeSetting(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeSetting/{0}", new Object[]{id})).request().delete();
    }

    public void addCategory(String name, String image, String meta_title, String meta_description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCategory/{0}/{1}/{2}/{3}", new Object[]{name, image, meta_title, meta_description})).request().post(null);
    }

    public <T> T getAllOrders(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllOrders");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addBanner(String title, String description, String link, String image, String is_active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addBanner/{0}/{1}/{2}/{3}/{4}", new Object[]{title, description, link, image, is_active})).request().post(null);
    }

    public <T> T getAllOrderDetails(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllOrderDetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeUser(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeUser/{0}", new Object[]{id})).request().delete();
    }

    public void addOrderDetail(String order_no, String product_id, String total) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addOrderDetail/{0}/{1}/{2}", new Object[]{order_no, product_id, total})).request().post(null);
    }

    public <T> T getAllBrands(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllBrands");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addOrder(String order_no, String user_id, String name, String address, String pincode) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addOrder/{0}/{1}/{2}/{3}/{4}", new Object[]{order_no, user_id, name, address, pincode})).request().post(null);
    }

    public void addBrand(String name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addBrand/{0}", new Object[]{name})).request().post(null);
    }

    public void removeCategory(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCategory/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAllSettings(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllSettings");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addGroup(String groups_name, String user_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addGroup/{0}/{1}", new Object[]{groups_name, user_id})).request().post(null);
    }

    public <T> T getAllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userCarts(Class<T> responseType, String user_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("userCarts/{0}", new Object[]{user_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllPayments(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPayments");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getBrand(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getBrand/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeReview(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeReview/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getCategory(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategory/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateUser(String id, String name, String email, String password, String address, String phone, String pincode) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{id, name, email, password, address, phone, pincode})).request().put(null);
    }

    public <T> T userProducts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("userProducts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCategories(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCategories");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateReview(String id, String rating, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateReview/{0}/{1}/{2}", new Object[]{id, rating, description})).request().put(null);
    }

    public void updateBanner(String id, String title, String description, String link, String image, String is_active) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateBanner/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{id, title, description, link, image, is_active})).request().put(null);
    }

    public <T> T getAllProducts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllProducts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addSetting(String sitemaplink, String keyword, String author, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addSetting/{0}/{1}/{2}/{3}", new Object[]{sitemaplink, keyword, author, description})).request().post(null);
    }

    public void updateSetting(String id, String sitemaplink, String keyword, String author, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateSetting/{0}/{1}/{2}/{3}/{4}", new Object[]{id, sitemaplink, keyword, author, description})).request().put(null);
    }

    public void removeOrder(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeOrder/{0}", new Object[]{id})).request().delete();
    }

    public void removeGroup(String id, String user_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeGroup/{0}/{1}", new Object[]{id, user_id})).request().delete();
    }

    public <T> T getSetting(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getSetting/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T productReviews(Class<T> responseType, String product_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("productReviews/{0}", new Object[]{product_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addPayment(String order_no, String amount, String method) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPayment/{0}/{1}/{2}", new Object[]{order_no, amount, method})).request().post(null);
    }

    public <T> T getBanner(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getBanner/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userOrders(Class<T> responseType, String user_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("userOrders/{0}", new Object[]{user_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
