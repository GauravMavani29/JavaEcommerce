package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.OrderDetails;
import models.Payments;
import models.Reviews;
import models.Users;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-06-13T14:06:54")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> pincode;
    public static volatile SingularAttribute<Orders, Date> createdAt;
    public static volatile SingularAttribute<Orders, Payments> orderPayment;
    public static volatile SingularAttribute<Orders, Integer> orderNo;
    public static volatile SingularAttribute<Orders, String> address;
    public static volatile SingularAttribute<Orders, String> name;
    public static volatile SingularAttribute<Orders, OrderDetails> orderDetail;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, Reviews> orderReview;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, Users> userId;

}