package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Orders;
import models.Products;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-28T18:36:20")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Date> createdAt;
    public static volatile SingularAttribute<OrderDetails, Integer> total;
    public static volatile SingularAttribute<OrderDetails, Orders> orderNo;
    public static volatile SingularAttribute<OrderDetails, Products> productId;
    public static volatile SingularAttribute<OrderDetails, Integer> id;

}