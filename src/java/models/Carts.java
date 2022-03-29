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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RUBYSTA JEWELS
 */
@Entity
@Table(name = "carts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carts.findAll", query = "SELECT c FROM Carts c"),
    @NamedQuery(name = "Carts.findById", query = "SELECT c FROM Carts c WHERE c.id = :id"),
    @NamedQuery(name = "Carts.findByQty", query = "SELECT c FROM Carts c WHERE c.qty = :qty"),
    @NamedQuery(name = "Carts.findByTotal", query = "SELECT c FROM Carts c WHERE c.total = :total"),
    @NamedQuery(name = "Carts.findByCreatedAt", query = "SELECT c FROM Carts c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Carts.findByUserId", query = "SELECT c FROM Carts c WHERE c.customerId = :user_id"),
})
public class Carts implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @Column(name = "created_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Products productId;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users customerId;

    public Carts() {
    }

    public Carts(Integer id) {
        this.id = id;
    }

    public Carts(Integer id, int qty, int total, Date createdAt) {
        this.id = id;
        this.qty = qty;
        this.total = total;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    public Users getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Users customerId) {
        this.customerId = customerId;
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
        if (!(object instanceof Carts)) {
            return false;
        }
        Carts other = (Carts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Carts[ id=" + id + " ]";
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
