/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsfbeans;

import beans.AdminbeanLocal;
import client.RestClient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import models.Brands;
import models.Categories;
import models.Products;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Named(value = "product")
@ApplicationScoped
public class product {
    @EJB
    private AdminbeanLocal ab;
    RestClient rest = new RestClient();
    
    private Response res;
    
    private Products product;
    private Collection<Categories> catlist;
    private Collection<Brands> brandlist;

    
    private Part uploadedFile;
    
    @PostConstruct
    public void init(){
        catlist = ab.getAllCategories();
        brandlist = ab.getAllBrands();
    }
    
    public product() {
        product = new Products();
    }
    
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    
        
    public void newProduct() throws IOException{
        System.out.println("WORKING");
            String fileName = "";
             try {
                   byte[] fileContent = new byte[(int) uploadedFile.getSize()];
                   InputStream in = uploadedFile.getInputStream();
                   in.read(fileContent);

                   File fileToCreate = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\product\\", getFilename(uploadedFile));
                   File f = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\product\\");
                   if (!f.exists()) {
                           f.mkdirs();
                   }
                   FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
                   fileOutStream.write(fileContent);
                   fileOutStream.flush();
                   fileOutStream.close();

                   System.out.println("fileName  " + fileName);
           } catch (IOException ex) {
               System.out.println(ex);
           }

           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName+ " Uploaded!"));

           rest.addProduct(product.getCategoryId().getId().toString(), product.getBrandId().getId().toString(), product.getName(), product.getSlug(), product.getDescription(), getFilename(uploadedFile),              String.valueOf(product.getQty()) , String.valueOf(product.getPrice()) , String.valueOf(product.getClubPoints()), product.getMetaTitle(), product.getMetaDescription(), String.valueOf(product.              getIsFeature()), String.valueOf(product.getIsActive()));
           product = new Products();
           FacesContext.getCurrentInstance().getExternalContext().redirect("display.xhtml");
       }
    
//    
//    
    public Collection<Products> showProductData(){
        // productgeneric = new GenericType<Collection<Product>>(){};
        // res = er.getProductsbycategory(Response.class, scid.toString(),sbname);
        // this.productlist = res.readEntity(productgeneric);
        // return this.productlist;
            return ab.getAllProducts();
        }
    
    public String editproductForm(Integer id){
        product = ab.getProduct(id);
        System.out.println(product.getBrandId());
        return "edit?faces-redirect=true";
    }
    
    public void editProduct() throws IOException{
        
        if(uploadedFile != null){
            System.out.println("saveFile method invoked..");
            System.out.println( "content-type:{0}" + uploadedFile.getContentType());
            System.out.println("filename:{0}" + uploadedFile.getName());
            System.out.println( "submitted filename:{0}"+ uploadedFile.getSubmittedFileName());
            System.out.println( "size:{0}" + uploadedFile.getSize());
             String fileName = "";
              try {
                    byte[] fileContent = new byte[(int) uploadedFile.getSize()];
                    InputStream in = uploadedFile.getInputStream();
                    in.read(fileContent);

                    File fileToCreate = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\product\\", getFilename(uploadedFile));
                    File f = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\product\\");
                    if (!f.exists()) {
                            f.mkdirs();
                    }
                    FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
                    fileOutStream.write(fileContent);
                    fileOutStream.flush();
                    fileOutStream.close();

                    System.out.println("fileName  " + fileName);
            } catch (IOException ex) {
                System.out.println(ex);


            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName+ " Uploaded!"));
            
           ab.updateProduct(product.getId(),product.getCategoryId().getId(), product.getBrandId().getId(), product.getName(), product.getSlug(), product.getDescription(), getFilename(uploadedFile),product.getQty() , product.getPrice() , product.getClubPoints(), product.getMetaTitle(), product.getMetaDescription(), product.getIsFeature(), product.getIsActive());
           product = new Products();
           uploadedFile = null;
           FacesContext.getCurrentInstance().getExternalContext().redirect("display.xhtml");
        }
        
        ab.updateProduct(product.getId(),product.getCategoryId().getId(), product.getBrandId().getId(), product.getName(), product.getSlug(), product.getDescription(), product.getImage(),product.getQty() , product.getPrice() , product.getClubPoints(), product.getMetaTitle(), product.getMetaDescription(), product.getIsFeature(), product.getIsActive());
        product = new Products();
            FacesContext.getCurrentInstance().getExternalContext().redirect("display.xhtml");
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public Collection<Brands> getBrandlist() {
        return brandlist;
    }

    public void setBrandlist(Collection<Brands> brandlist) {
        this.brandlist = brandlist;
    }
       
    
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Collection<Categories> getCatlist() {
        return catlist;
    }

    public void setCatlist(Collection<Categories> catlist) {
        this.catlist = catlist;
    }
    
}
