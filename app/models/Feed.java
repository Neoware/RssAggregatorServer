package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Neoware on 28/03/16.
 */

@Entity
@Table(name="feeds")
public class Feed extends Model implements Serializable {

    @Id
    private int id;
    private String name;
    @Column(unique = true)
    private String url;
    @OneToMany(mappedBy = "feed")
    private List<FeedArticle> feedArticles = new ArrayList<>();
    @OneToMany(mappedBy = "feed")
    private List<UserSubscription> userSubscriptions = new ArrayList<>();


    public Feed(String _url, String _name){
        this.url = _url;
        this.name = _name;

    }

    //region getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FeedArticle> getFeedArticles() {
        return feedArticles;
    }

    public void setFeedArticles(List<FeedArticle> feedArticles) {
        this.feedArticles = feedArticles;
    }


    //endregion

}
