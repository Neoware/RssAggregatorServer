package models;

import com.avaje.ebean.Model;

/**
 * Created by Neoware on 4/6/2016.
 */
public class UserSubscriptionDao {
    public static final Model.Finder<Integer,UserSubscription> find = new Model.Finder<>( UserSubscription.class );
}
