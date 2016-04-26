package api;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import models.User;
import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;

import play.mvc.Result;

public class UserApi extends Controller {
    public static Result index () {
        try {
            // List userList = new List(UserDao.findAll())
            // gson.toJson(userList)
            return ok("Sample user List");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing user list");
        }
    }

    public static Result read() {
        try {
            return ok("Finding user of id ");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Research failed");
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result create() {
        JsonNode json = request().body().asJson();
        Gson gson = new Gson();
        Logger.info("Gson Unpacking... USER");
        String tmp = json.toString();
        User user = new User();
        Logger.info(tmp);
        try {
            user = gson.fromJson(tmp, models.User.class);
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(e.getMessage());
        }
        Logger.info("C'est pas legal");
        // User.create(user);
        Logger.info("Sending...");
        //return ok(String.valueOf(user.id));
        return ok("User Saved");
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result update() {
        JsonNode json = request().body().asJson();
        Gson gson = new Gson();
        Logger.info("Gson Unpacking... USER");
        String tmp = json.toString();
        User user = new User();
        Logger.info(json.toString());
        try {
            user = gson.fromJson(tmp, models.User.class);
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(e.getMessage());
        }
        Logger.info("C'est pas legal");
        // User.create(user);
        Logger.info("Sending...");
        //return ok(String.valueOf(user.id));
        return ok("User updated");
    }
    
    public static Result delete(Integer id) {
        try {
            // User currentUser = new List(UserDao.find(id))
            // gson.toJson(currentUser)
            return ok("Finding user of id " + id);
        } catch (Exception e){
            Logger.error(e.getMessage());
            return badRequest("Finding user of id " + id);
        }
    }
}
