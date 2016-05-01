package models;

import com.avaje.ebean.Model;

import java.util.List;

/**
 * Created by Neoware on 4/6/2016.
 */
public class UserArticleDao {
    public static final Model.Finder<Integer,UserArticle> find = new Model.Finder<>( UserArticle.class );

    public List<UserArticle> findAll(){
        return find.all();
    }

    public UserArticle findByUserAndArticleId(int _user_id, int _article_id){
        try {
            UserArticle temp = find.where().eq("user_id", _user_id).eq("feed_articles_id", _article_id).findUnique();
            return temp;
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public void Create(int userId, int feedId){
        User tempUser = new User();
        tempUser.setId(userId);
        FeedArticle tempFeedArticle = new FeedArticle();
        tempFeedArticle.setId(feedId);
        UserArticle toCreate = new UserArticle(tempUser, tempFeedArticle);
        toCreate.save();
    }


    public void updateArticleAsRead(UserArticle temp){
        temp.setRead(true);
        temp.update();
    }

    public void updateArticleAsUnread(UserArticle temp){
        temp.setRead(false);
        temp.update();
    }


}
