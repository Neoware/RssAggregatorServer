package models;

import com.avaje.ebean.Model;

import java.util.List;

/**
 * Created by Neoware on 4/6/2016.
 */
public class FeedArticleDao {
    public static final Model.Finder<Integer,FeedArticle> find = new Model.Finder<>( FeedArticle.class );

    public List<FeedArticle> findAll(){
        return find.all();
    }
}
