package models;

import com.avaje.ebean.LikeType;
import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neoware on 4/6/2016.
 */

@Entity
@Table(name="feed_articles")
public class FeedArticle {
    @Id
    private int id;
    private String title;
    private String content;
    private int feedId;
    @ManyToOne()
    private Feed feed;
    @OneToMany(mappedBy = "feedArticle")
    private List<UserArticle> userArticles = new ArrayList<>();
    public static final Model.Finder<Integer,FeedArticle> find = new Model.Finder<>( FeedArticle.class );

    //region getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feed_id) {
        this.feedId = feed_id;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public List<UserArticle> getUserArticles() {
        return userArticles;
    }

    public void setUserArticles(List<UserArticle> userArticles) {
        this.userArticles = userArticles;
    }
    //endregion
}
