package models;

import javax.persistence.*;

/**
 * Created by Neoware on 4/6/2016.
 */

@Entity
@Table(name="user_articles")
public class UserArticle {
    @Id
    private int id;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "feed_articles_id")
    private FeedArticle feedArticle;
    private boolean isRead;

    //region getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
