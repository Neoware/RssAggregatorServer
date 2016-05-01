package api;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.User;
import models.UserDao;
import models.UserService;
import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;

import play.mvc.Result;

import java.util.Map;

public class UserApi extends Controller {
    public static User verifyAuth(String hash) {
        try {
            UserService service = new UserService();
            return service.authenticateByHash(hash);
        } catch (Exception e) {
            return null;
        }

    }

    public Result index () {
        try {
            // List userList = new List(UserDao.findAll())
            // gson.toJson(userList)
            return ok("Sample user List");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing user list");
        }
    }

    public Result read() {
        try {
            return ok("Finding user of id ");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Research failed");
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result create() {

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
        UserService service = new UserService();
        service.CreateUser(user.getUsername(), user.getPassword(), user.getMail());
        return ok();
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result update() {
        // Map header = request().headers()
        User currentUser = verifyAuth(request().getHeader("authentication"));

        if (currentUser == null) {
            return notFound();
        }

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
        UserService service = new UserService();
        service.UpdateUser(user.getUsername(), user.getPassword(), user.getMail());
        Logger.info("Sending...");
        //return ok(String.valueOf(user.id));
        return ok("User updated");
    }
    
    public Result delete() {
        try {
            User currentUser = verifyAuth(request().getHeader("authentication"));
            if (currentUser == null) {
                return notFound();
            }
            UserService service = new UserService();
            service.DeleteUser(currentUser.getUsername());
            return ok("Deleting user named: " + currentUser.getUsername());
        } catch (Exception e){
            Logger.error(e.getMessage());
            return badRequest();
        }
    }

    public Result auth() {
        try {
            User currentUser = verifyAuth(request().getHeader("authentication"));

            if (currentUser == null) {
                return notFound();
            }
            return ok("mes couilles");
        } catch (Exception e){
            Logger.error(e.getMessage());
            return badRequest();
        }
    }
}
