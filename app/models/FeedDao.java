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

}
