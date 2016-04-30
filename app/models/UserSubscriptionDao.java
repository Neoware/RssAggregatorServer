package models;

import com.avaje.ebean.Model;

import java.util.List;

/**
 * Created by Neoware on 4/6/2016.
 */
public class UserSubscriptionDao {
    public static final Model.Finder<Integer,UserSubscription> find = new Model.Finder<>( UserSubscription.class );

    public List<UserSubscription> findAll(){
        return find.all();
    }

    public void createSubscription(UserSubscription _userSubscription){
        _userSubscription.save();
    }


    public void createSubscription(User _user, Feed _feed) {
        UserSubscription userSubscription = new UserSubscription();
        userSubscription.setFeed(_feed);
        userSubscription.setUser(_user);
        userSubscription.save();
    }

    public UserSubscription findByUserAndFeed(User tempUser, Feed tempFeed) {
        return find.where().eq("user_id", tempUser.getId()).eq("feed_id", tempFeed.getId()).findUnique();
    }

    public void deleteSubscription(UserSubscription subscription) {
        subscription.delete();
    }
}
