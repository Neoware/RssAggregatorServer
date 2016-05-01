package models;

import com.avaje.ebean.LikeType;
import com.avaje.ebean.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private String author;
    private LocalDate publishedDate;
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

    public FeedArticle(String _title, String _content, Feed _feed, String _author, LocalDate _publishedDate){
        title = _title;
        content = _content;
        feed = _feed;
        author = _author;
        publishedDate = _publishedDate;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
    //endregion
}
