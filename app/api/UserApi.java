package api;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import models.User;
import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;

import play.mvc.Result;

/**
 * Created by Neti on 13/04/2016.
 */

public class UserApi extends Controller {
    public static Result index () {
        try {
            // List userList = new List(UserDao.findAll())
            // gson.toJson(userList)
            return ok(new String("Sample user List"));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Error in processing user list"));
        }
    }

    public static Result read(Integer id) {
        try {
            // User currentUser = new List(UserDao.find(id))
            // gson.toJson(currentUser)
            return ok(new String("Finding user of id " + id));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Research failed"));
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result create() {
        JsonNode json = request().body().asJson();
        Gson gson = new Gson();
        Logger.info("Gson Unpacking... USER");
        String tmp = new String(json.toString());
        User user = new User();
        Logger.info(tmp);
        try {
            user = gson.fromJson(tmp, models.User.class);
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
        Logger.info("C'est pas legal");
        // User.create(user);
        Logger.info("Sending...");
        return ok(String.valueOf(user.id));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result update() {
        JsonNode json = request().body().asJson();
        Gson gson = new Gson();
        Logger.info("Gson Unpacking... USER");
        String tmp = new String(json.toString());
        User user = new User();
        Logger.info(json.toString());
        try {
            user = gson.fromJson(tmp, models.User.class);
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
        Logger.info("C'est pas legal");
        // User.create(user);
        Logger.info("Sending...");
        return ok(String.valueOf(user.id));
    }
    
    public static Result delete(Integer id) {
        try {
            // User currentUser = new List(UserDao.find(id))
            // gson.toJson(currentUser)
            return ok(new String("Finding user of id " + id));
        } catch (Exception e){
            Logger.error(e.getMessage());
            return badRequest(new String("Finding user of id " + id));
        }
    }
}
