package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Carts;
import models.Groups;
import models.Orders;
import models.Reviews;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-06-15T11:47:17")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> pincode;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, Integer> clubpoints;
    public static volatile CollectionAttribute<Users, Orders> ordersCollection;
    public static volatile SingularAttribute<Users, Integer> isActive;
    public static volatile CollectionAttribute<Users, Reviews> reviewsCollection;
    public static volatile CollectionAttribute<Users, Carts> cartsCollection;
    public static volatile SingularAttribute<Users, Date> createdAt;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> phone;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile CollectionAttribute<Users, Groups> groupsCollection;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, Short> roleAs;

}