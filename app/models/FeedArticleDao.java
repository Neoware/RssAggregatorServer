package models;

import com.avaje.ebean.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by Neoware on 4/6/2016.
 */
public class FeedArticleDao {
    public static final Model.Finder<Integer,FeedArticle> find = new Model.Finder<>( FeedArticle.class );

    public List<FeedArticle> findAll(){
        return find.all();
    }

    public FeedArticle findUserArticleByArticleId(int _article_id){
        return find.byId(_article_id);
    }


    public List<FeedArticle> findTitlesByFeedId(int _feed_id){
        List<FeedArticle> temp = find.where().eq("feed_id", _feed_id).select("title").findList();
        return temp;
    }

    public void Create(String title, String content, Feed feed, String author, Date publishedDate){
        FeedArticle temp = new FeedArticle(title, content, feed, author, publishedDate);
        temp.save();
    }
}
