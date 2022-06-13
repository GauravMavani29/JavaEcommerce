package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-06-13T15:09:02")
@StaticMetamodel(Settings.class)
public class Settings_ { 

    public static volatile SingularAttribute<Settings, Date> createdAt;
    public static volatile SingularAttribute<Settings, String> author;
    public static volatile SingularAttribute<Settings, String> description;
    public static volatile SingularAttribute<Settings, Integer> id;
    public static volatile SingularAttribute<Settings, String> keyword;
    public static volatile SingularAttribute<Settings, String> sitemapLink;

}