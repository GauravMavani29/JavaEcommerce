/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Entity
@Table(name = "banners")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banners.findAll", query = "SELECT b FROM Banners b"),
    @NamedQuery(name = "Banners.findById", query = "SELECT b FROM Banners b WHERE b.id = :id"),
    @NamedQuery(name = "Banners.findByTitle", query = "SELECT b FROM Banners b WHERE b.title = :title"),
    @NamedQuery(name = "Banners.findByDescription", query = "SELECT b FROM Banners b WHERE b.description = :description"),
    @NamedQuery(name = "Banners.findByLink", query = "SELECT b FROM Banners b WHERE b.link = :link"),
    @NamedQuery(name = "Banners.findByImage", query = "SELECT b FROM Banners b WHERE b.image = :image"),
    @NamedQuery(name = "Banners.findByIsActive", query = "SELECT b FROM Banners b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "Banners.findByCreatedAt", query = "SELECT b FROM Banners b WHERE b.createdAt = :createdAt")})
public class Banners implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private int isActive;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Banners() {
    }

    public Banners(Integer id) {
        this.id = id;
    }

    public Banners(Integer id, String title, String description, String link, String image, int isActive) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.link = link;
        this.image = image;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banners)) {
            return false;
        }
        Banners other = (Banners) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Banners[ id=" + id + " ]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
