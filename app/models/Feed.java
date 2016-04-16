package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
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
    private String url;
    @OneToMany(mappedBy = "feed")
    private List<FeedArticle> feedArticles = new ArrayList<>();
    @OneToMany(mappedBy = "feed")
    private List<UserSubscription> userSubscriptions = new ArrayList<>();

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
