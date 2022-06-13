package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.OrderDetails;
import models.Payments;
import models.Reviews;
import models.Users;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-06-13T12:28:58")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> pincode;
    public static volatile SingularAttribute<Orders, Date> createdAt;
    public static volatile SingularAttribute<Orders, Integer> orderNo;
    public static volatile SingularAttribute<Orders, String> address;
    public static volatile CollectionAttribute<Orders, Payments> paymentsCollection;
    public static volatile CollectionAttribute<Orders, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Orders, String> name;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile CollectionAttribute<Orders, Reviews> reviewsCollection;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, Users> userId;

}