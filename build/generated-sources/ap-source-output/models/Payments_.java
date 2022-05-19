package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Orders;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-05-19T19:26:55")
@StaticMetamodel(Payments.class)
public class Payments_ { 

    public static volatile SingularAttribute<Payments, Orders> orderNoPayment;
    public static volatile SingularAttribute<Payments, Integer> totalAmount;
    public static volatile SingularAttribute<Payments, Date> createdAt;
    public static volatile SingularAttribute<Payments, String> paymentMethod;
    public static volatile SingularAttribute<Payments, Integer> id;

}