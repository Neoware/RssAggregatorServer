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
}
