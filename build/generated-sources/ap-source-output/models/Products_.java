package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Brands;
import models.Carts;
import models.Categories;
import models.OrderDetails;
import models.Reviews;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-06-13T12:28:58")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> image;
    public static volatile CollectionAttribute<Products, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Products, String> description;
    public static volatile SingularAttribute<Products, Integer> isActive;
    public static volatile CollectionAttribute<Products, Reviews> reviewsCollection;
    public static volatile SingularAttribute<Products, String> metaDescription;
    public static volatile CollectionAttribute<Products, Carts> cartsCollection;
    public static volatile SingularAttribute<Products, Date> createdAt;
    public static volatile SingularAttribute<Products, Integer> price;
    public static volatile SingularAttribute<Products, Integer> qty;
    public static volatile SingularAttribute<Products, String> metaTitle;
    public static volatile SingularAttribute<Products, Brands> brandId;
    public static volatile SingularAttribute<Products, String> name;
    public static volatile SingularAttribute<Products, Integer> clubPoints;
    public static volatile SingularAttribute<Products, Integer> id;
    public static volatile SingularAttribute<Products, String> slug;
    public static volatile SingularAttribute<Products, Categories> categoryId;
    public static volatile SingularAttribute<Products, Integer> isFeature;

}