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

    public void updateArticleAsRead(int _user_id, int _article_id){
       UserArticle temp = find.where().eq("user_id", _user_id).eq("feed_articles_id", _article_id).findUnique();
        temp.setRead(true);
        temp.update();
    }

    public void updateArticleAsUnread(int _user_id, int _article_id){
        UserArticle temp = find.where().eq("user_id", _user_id).eq("feed_articles_id", _article_id).findUnique();
        temp.setRead(false);
        temp.update();
    }


}
