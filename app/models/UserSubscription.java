package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Neoware on 4/6/2016.
 */
@Entity
@Table(name="user_subscriptions")
public class UserSubscription extends Model implements Serializable {

    @Id
    private int id;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Override
    public String toString() {
        return "UserSubscription{" +
                "id=" + id +
                ", user=" + user +
                ", feed=" + feed +
                '}';
    }

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

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }
    //endregion
}
