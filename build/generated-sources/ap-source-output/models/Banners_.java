package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-06-13T12:28:58")
@StaticMetamodel(Banners.class)
public class Banners_ { 

    public static volatile SingularAttribute<Banners, String> image;
    public static volatile SingularAttribute<Banners, Date> createdAt;
    public static volatile SingularAttribute<Banners, String> link;
    public static volatile SingularAttribute<Banners, String> description;
    public static volatile SingularAttribute<Banners, Integer> id;
    public static volatile SingularAttribute<Banners, String> title;
    public static volatile SingularAttribute<Banners, Integer> isActive;

}