package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Users;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-28T18:36:20")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> pincode;
    public static volatile SingularAttribute<Orders, Date> createdAt;
    public static volatile SingularAttribute<Orders, Integer> orderNo;
    public static volatile SingularAttribute<Orders, String> address;
    public static volatile SingularAttribute<Orders, String> name;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, Users> userId;

}