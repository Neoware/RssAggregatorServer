package api;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Neti on 13/04/2016.
 */

public class FeedApi extends Controller {
    public static Result index () {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok(new String("Sample Feed List"));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Error in processing feed list"));
        }

    }

    public static Result read(Long id) {
        try {
            // Feed currentFeed = new List(FeedDao.find(id))
            // gson.toJson(currentFeed)
            return ok(new String("Finding feed with  id " + id));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Research on feed item failed"));
        }
    }
}
