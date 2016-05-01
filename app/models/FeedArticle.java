package models;

import com.avaje.ebean.LikeType;
import com.avaje.ebean.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neoware on 4/6/2016.
 */

@Entity
@Table(name="feed_articles")
public class FeedArticle extends Model implements Serializable{
    @Id
    private int id;
    private String title;
    private String content;
    @ManyToOne()
    @JoinColumn(name = "feed_id")
    private Feed feed;
    @OneToMany(mappedBy = "feedArticle")
    private List<UserArticle> userArticles = new ArrayList<>();

    @Override
    public String toString() {
        return "FeedArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", feed=" + feed +
                ", userArticles=" + userArticles +
                '}';
    }

    public String toJson() {
        return null;
    }

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
