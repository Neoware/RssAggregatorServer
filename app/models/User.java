package models;


import com.avaje.ebean.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neoware on 28/03/16.
 */

@Entity
@Table(name="users")
public class User extends Model implements Serializable{

    @Id
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;
    private String mail;
    @OneToMany(mappedBy = "user")
    private List<UserSubscription> userSubscriptions = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<UserArticle> userArticles = new ArrayList<>();

    public User(String _username, String _password, String _mail){
        username = _username;
        password = _password;
        mail = _mail;
    }

    //region getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<UserSubscription> getUserSubscriptions() {
        return userSubscriptions;
    }

    public void setUserSubscriptions(List<UserSubscription> userSubscriptions) {
        this.userSubscriptions = userSubscriptions;
    }

    public List<UserArticle> getUserArticles() {
        return userArticles;
    }

    public void setUserArticles(List<UserArticle> userArticles) {
        this.userArticles = userArticles;
    }
    //endregion



}
