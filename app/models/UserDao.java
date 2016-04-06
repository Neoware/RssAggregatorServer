package models;

import com.avaje.ebean.Model;

/**
 * Created by Neoware on 4/6/2016.
 */
public class UserDao {

    public static final Model.Finder<Integer,User> find = new Model.Finder<>( User.class );

}
