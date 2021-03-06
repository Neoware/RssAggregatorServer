package models;

import com.avaje.ebean.Model;

import java.util.List;
import models.User;

/**
 * Created by Neoware on 4/6/2016.
 */
public class UserDao {

    public static final Model.Finder<Integer,User> find = new Model.Finder<>( User.class );

    public List<User> findAll(){
        return find.all();
    }

    public User findUserByUsername(String _name){
        return find.where().eq("username", _name).findUnique();
    }

    public User FindUserById(int _id){
        return find.byId(_id);
    }

    public List<UserSubscription> FindUserSubscriptionsByUserId(int _id){
        User temp = find.byId(_id);
        if (temp != null)
            return temp.getUserSubscriptions();
        else
            return null;
    }

    public List<UserArticle> FindUserArticlesByUserId(int _id){
        User temp = find.byId(_id);
        if (temp != null)
            return temp.getUserArticles();
        else
            return null;
    }

    public User findByHash(String userHash){
        return find.where().eq("user_hash", userHash).findUnique();
    }


    public void createUser(User _user){
        _user.save();
    }

    public void updateUser(User _user){
        _user.update();
    }

    public void deleteUser(User _user){
        _user.delete();
    }

    public void deleteUserById(int _id){
        find.deleteById(_id);
    }
}
