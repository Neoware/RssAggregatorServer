package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private int feed_id;
    @ManyToOne()
    private Feed feed;
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

    public int getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(int feed_id) {
        this.feed_id = feed_id;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }
    //endregion
}
