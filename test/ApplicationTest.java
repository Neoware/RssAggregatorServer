import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import models.*;
import org.junit.*;

import play.db.Database;
import play.db.Databases;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;


/**
 *
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 *
 */
public class ApplicationTest {


    @Test
    public void TestUserDao() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                UserDao userDao = new UserDao();
                User check = userDao.FindUserById(1);
                assertEquals("Failed to retrieve user", "neoware", check.getUsername());
                User test = new User("user", "password", "testuser@gmail.com");
                userDao.createUser(test);
                User created = userDao.findUserByUsername("user");
                assertEquals("Failed to create user or to retrieve the newly created user", "user", created.getUsername());
                userDao.deleteUser(created);
            }
        });
    }

    @Test
        public void TestSubscriptionService(){
        running(fakeApplication(), new Runnable() {
            public void run() {
                SubscriptionService subscriptionService = new SubscriptionService();
                //Subscribe someone
                subscriptionService.Subscribe("neoware", "www.test-feed/rss");
                //Try to subscribe to the same feed again
                subscriptionService.Subscribe("neoware", "www.test-feed/rss");
                //Try to subscribe to a non existing feed
                subscriptionService.Subscribe("neoware", "www.fake/rss");
                //Delete fake feed (will delete subscriptions through foreign key cascade)
                FeedDao feedDao = new FeedDao();
                feedDao.Delete("www.fake/rss");
                //Unsubscribe for the feed
                subscriptionService.Unsubscribe("neoware","www.test-feed/rss");
                // Try to unsubscribe for an already unsubscribed feed
                subscriptionService.Unsubscribe("neoware","www.test-feed/rss");
            }
        });
    }



    @Test
    public void TestUserService(){
        running(fakeApplication(), new Runnable() {
            public void run() {
                UserService userService = new UserService();
                //Try to create an already existing user;
                userService.CreateUser("neoware", "test", "test");
                //Try to create a user
                userService.CreateUser("new", "test", "test");
                //Try to update a user
                userService.UpdateUser("new", "changed", "changed");
                //Try to create then delete a user
                userService.CreateUser("temp", "test", "test");
                userService.DeleteUser("temp");
                //Try to delete an already deleted user
                userService.DeleteUser("temp");
                //delete new
                userService.DeleteUser("new");
            }
        });
    }

    @Test
    public void TestFeedServiceReadStatus(){
        running(fakeApplication(), new Runnable() {
            public void run() {
                FeedService feedService = new FeedService();
                // Try to mark as read
                feedService.MarkAsRead("neoware", 1);
                // Try to mark as unread
                feedService.MarkAsUnread("neoware", 3);
                // Try to mark as read an article that doesn't belong to this user
                feedService.MarkAsRead("neoware", 5);
                // Try to mark as unread an article that doesn't belong to this user
                feedService.MarkAsUnread("neoware", 6);
            }
        });
    }


}

