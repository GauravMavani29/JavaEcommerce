package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Products;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-06-13T12:28:58")
@StaticMetamodel(Brands.class)
public class Brands_ { 

    public static volatile SingularAttribute<Brands, Date> createdAt;
    public static volatile CollectionAttribute<Brands, Products> productsCollection;
    public static volatile SingularAttribute<Brands, String> name;
    public static volatile SingularAttribute<Brands, Integer> id;

}