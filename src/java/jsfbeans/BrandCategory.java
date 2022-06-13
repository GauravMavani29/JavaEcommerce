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
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import jdk.incubator.jpackage.internal.IOUtils;
import static jsfbeans.auth.SALT;
import static jsfbeans.auth.generateHash;
import models.*;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Named(value = "brandCategory")
@ApplicationScoped
public class BrandCategory {
    @EJB
    private AdminbeanLocal ab;
    RestClient rest = new RestClient();
    
    private Response res;
    private GenericType<Brands> b;
    private GenericType<Categories> c;
    
    private GenericType<Collection<Brands>> brandeneric;
    private Collection<Brands> brandlist;
    
    private GenericType<Collection<Categories>> categorygeneric;
    private Collection<Categories> categorylist;
    
    private Brands brand;
    private Categories category;
    
    
    private Part uploadedFile;
    
    

    public BrandCategory() {
        brand = new Brands();
        category = new Categories();
    }
    
    public String newBrand(){
        rest.addBrand(brand.getName());
        brand = new Brands();
        return "display?faces-redirect=true";
    }
    
    public Collection<Brands> showBrandData(){
//         brandeneric = new GenericType<Collection<Brands>>(){};
//         res = rest.getAllBrands(Response.class);
//         this.brandlist = res.readEntity(brandeneric);
//         return this.brandlist;
            return ab.getAllBrands();
        }
    
    public String editbrandForm(Integer id){
//        b = new GenericType<Brands>(){};
//        res = rest.getBrand(Response.class, id.toString());
//        System.out.print(res);
//        brand = res.readEntity(b);
//        System.out.print(brand);
          brand = ab.getBrand(id);
        return "edit?faces-redirect=true";
    }
    
    public String editBrand(){
        ab.updateBrand(brand.getId(), brand.getName());
        brand = new Brands();
        return "display?faces-redirect=true";
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
    
    public void newCategory() throws IOException{
        
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

                File fileToCreate = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\category\\", getFilename(uploadedFile));
                File f = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\category\\");
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
        
        rest.addCategory(category.getName(), getFilename(uploadedFile) , category.getMetaTitle(), category.getMetaDescription());
        category = new Categories();
        uploadedFile = null;
        FacesContext.getCurrentInstance().getExternalContext().redirect("display.xhtml");
    }
    
    
    public Collection<Categories> showCategoryData(){
        // productgeneric = new GenericType<Collection<Product>>(){};
        // res = er.getProductsbycategory(Response.class, scid.toString(),sbname);
        // this.productlist = res.readEntity(productgeneric);
        // return this.productlist;
            return ab.getAllCategories();
        }
    
    public String editcategoryForm(Integer id){
        category = ab.getCategory(id);
        
        return "edit?faces-redirect=true";
    }
    
    public void editCategory () throws IOException{
        
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

                    File fileToCreate = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\category\\", getFilename(uploadedFile));
                    File f = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\category\\");
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

           ab.updateCategory(category.getId(), category.getName(), getFilename(uploadedFile), category.getMetaTitle(), category.getMetaDescription());
           category = new Categories();
           uploadedFile = null;
           FacesContext.getCurrentInstance().getExternalContext().redirect("display.xhtml");
        }
        
        ab.updateCategory(category.getId(), category.getName(), category.getImage(), category.getMetaTitle(), category.getMetaDescription());
        category = new Categories();
        FacesContext.getCurrentInstance().getExternalContext().redirect("display.xhtml");
    }
    
    
    
   
    public Part getUploadedFile() {
            return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
            this.uploadedFile = uploadedFile;
    }
    
    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
