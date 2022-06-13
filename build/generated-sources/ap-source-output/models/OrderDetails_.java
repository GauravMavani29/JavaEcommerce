package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Orders;
import models.Products;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-06-13T15:09:02")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Date> createdAt;
    public static volatile SingularAttribute<OrderDetails, Integer> total;
    public static volatile SingularAttribute<OrderDetails, Products> productId;
    public static volatile SingularAttribute<OrderDetails, Orders> orderNoDetails;
    public static volatile SingularAttribute<OrderDetails, Integer> id;

}