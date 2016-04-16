import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import models.User;
import models.UserDao;
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
    public void TestUserDao(){
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

}
