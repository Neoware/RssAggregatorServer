package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Neoware on 4/6/2016.
 */

@Entity
@Table(name="user_articles")
public class UserArticle {
    @Id
    private int id;
    private int userId;
    @ManyToOne()
    private User user;
    private int feedArticleId;
    @ManyToOne()
    private FeedArticle feedArticle;
    private boolean isRead;

    //region getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFeedArticleId() {
        return feedArticleId;
    }

    public void setFeedArticleId(int feedArticleId) {
        this.feedArticleId = feedArticleId;
    }

    public FeedArticle getFeedArticle() {
        return feedArticle;
    }

    public void setFeedArticle(FeedArticle feedArticle) {
        this.feedArticle = feedArticle;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
    //endregion
}
