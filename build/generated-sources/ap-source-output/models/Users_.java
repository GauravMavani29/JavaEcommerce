package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Groups;
import models.Orders;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-28T18:36:20")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> pincode;
    public static volatile SingularAttribute<Users, Date> createdAt;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, String> phone;
    public static volatile SingularAttribute<Users, Integer> clubpoints;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile CollectionAttribute<Users, Orders> ordersCollection;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Integer> isActive;
    public static volatile CollectionAttribute<Users, Groups> groupsCollection;
    public static volatile SingularAttribute<Users, String> email;

}