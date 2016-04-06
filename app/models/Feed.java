package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Neoware on 28/03/16.
 */

@Entity
@Table(name="feeds")
public class Feed {

    @Id
    private int id;
    private String name;
    private String url;
    public static final Model.Finder<Integer,Feed> find = new Model.Finder<>( Feed.class );

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
    //endregion

}
