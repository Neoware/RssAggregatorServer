package models;

import com.avaje.ebean.Model;

/**
 * Created by Neoware on 4/6/2016.
 */
public class FeedArticleDao {
    public static final Model.Finder<Integer,FeedArticle> find = new Model.Finder<>( FeedArticle.class );
}
