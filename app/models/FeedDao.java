package models;

import com.avaje.ebean.Model;

import java.util.List;

/**
 * Created by Neoware on 4/6/2016.
 */
public class FeedDao {
    public static final Model.Finder<Integer,Feed> find = new Model.Finder<>( Feed.class );

    public List<Feed> findAll(){
        return find.all();
    }

    public List<FeedArticle> findArticlesbyFeedId(int _feed_id){
        Feed temp = find.byId(_feed_id);
        return temp.getFeedArticles();
    }

    public Feed findByUrl(String _url){
         return find.where().eq("url", _url).findUnique();
    }

    public void Create(String url){
        Feed temp = new Feed(url);
        temp.save();
    }

    public void Delete(String url){
        Feed temp = findByUrl(url);
        temp.delete();
    }
}
