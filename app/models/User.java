package models;


import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Neoware on 28/03/16.
 */

@Entity
@Table(name="users")
public class User extends Model {

    @Id
    public int id;

    public String username;

    public String password;

    public String mail;

    public static final Finder<Integer,User> find = new Finder<>( User.class );

}
