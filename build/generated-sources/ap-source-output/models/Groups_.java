package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Users;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-28T18:36:20")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, String> groupName;
    public static volatile SingularAttribute<Groups, Integer> id;
    public static volatile SingularAttribute<Groups, Users> userId;

}