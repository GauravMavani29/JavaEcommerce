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
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import models.Banners;
import models.Brands;
import models.Categories;
import models.Settings;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Named(value = "settingBanner")
@ApplicationScoped
public class SettingBanner {

    /**
     * Creates a new instance of SettingBanner
     */
    
    @EJB
    private AdminbeanLocal ab;
    RestClient rest = new RestClient();

    
    private Response res;
    private GenericType<Settings> s;
    
    private Settings setting;
    private Banners banner;
    
     private Part uploadedFile;
    
    public SettingBanner() {
        setting = new Settings();
        banner = new Banners();
    }
    
    public String newSetting(){
        rest.addSetting(setting.getSitemapLink(), setting.getKeyword(), setting.getAuthor(), setting.getDescription());
        setting = new Settings();
        return "display?faces-redirect=true";
    }
    
    public Collection<Settings> showSettingData(){
            return ab.getAllSettings();
        }
    
    public String editsettingForm(Integer id){
        setting = ab.getSetting(id);
        return "edit?faces-redirect=true";
    }
    
    public String editSetting(){
        ab.updateSetting(setting.getId(), setting.getSitemapLink(), setting.getKeyword(), setting.getAuthor(), setting.getDescription());
        setting = new Settings();
        return "display?faces-redirect=true";
    }
    
    
    public String deleteSetting(Integer id){
        ab.removeSetting(id);
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
    
    public void newBanner() throws IOException{
        
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

                File fileToCreate = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\banner\\", getFilename(uploadedFile));
                File f = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\banner\\");
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
        
        rest.addBanner(banner.getTitle(), banner.getDescription(), banner.getLink(), getFilename(uploadedFile), String.valueOf(banner.getIsActive()));
        banner = new Banners();
        uploadedFile = null;
        FacesContext.getCurrentInstance().getExternalContext().redirect("display.xhtml");
    }
    
    
    public Collection<Banners> showBannerData(){
            return ab.getAllBanners();
        }
    
    public String editbannerForm(Integer id){
        banner = ab.getBanner(id);
        
        return "edit?faces-redirect=true";
    }
    
    public void editBanner () throws IOException{
        
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

                    File fileToCreate = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\banner\\", getFilename(uploadedFile));
                    File f = new File("D:\\Sem_8_Project\\Project\\EcommerceProject\\web\\resources\\banner\\");
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

           ab.updateBanner(banner.getId(), banner.getTitle(), banner.getDescription(), banner.getLink(), getFilename(uploadedFile), banner.getIsActive());
           banner = new Banners();
           uploadedFile = null;
           FacesContext.getCurrentInstance().getExternalContext().redirect("display.xhtml");
        }
        
        ab.updateBanner(banner.getId(), banner.getTitle(), banner.getDescription(), banner.getLink(), banner.getImage(), banner.getIsActive());
        banner = new Banners();
        FacesContext.getCurrentInstance().getExternalContext().redirect("display.xhtml");
    }
    
    public String deleteBanner(Integer id){
        ab.removeBanner(id);
        return "display?faces-redirect=true";
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public Banners getBanner() {
        return banner;
    }

    public void setBanner(Banners banner) {
        this.banner = banner;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
    public Settings getSetting() {
        return setting;
    }

    public void setSetting(Settings setting) {
        this.setting = setting;
    }
}
