package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Orders;
import models.Products;
import models.Users;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-06-13T12:28:58")
@StaticMetamodel(Reviews.class)
public class Reviews_ { 

    public static volatile SingularAttribute<Reviews, Date> createdAt;
    public static volatile SingularAttribute<Reviews, Orders> orderNo;
    public static volatile SingularAttribute<Reviews, Products> productId;
    public static volatile SingularAttribute<Reviews, Integer> rating;
    public static volatile SingularAttribute<Reviews, Users> customerId;
    public static volatile SingularAttribute<Reviews, String> description;
    public static volatile SingularAttribute<Reviews, Integer> id;

}