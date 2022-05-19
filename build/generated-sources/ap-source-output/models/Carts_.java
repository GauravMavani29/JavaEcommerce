package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Products;
import models.Users;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-05-19T19:26:55")
@StaticMetamodel(Carts.class)
public class Carts_ { 

    public static volatile SingularAttribute<Carts, Date> createdAt;
    public static volatile SingularAttribute<Carts, Integer> total;
    public static volatile SingularAttribute<Carts, Products> productId;
    public static volatile SingularAttribute<Carts, Integer> qty;
    public static volatile SingularAttribute<Carts, Users> customerId;
    public static volatile SingularAttribute<Carts, Integer> id;

}