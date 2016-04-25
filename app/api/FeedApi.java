package api;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Neti on 13/04/2016.
 */

public class FeedApi extends Controller {
    public static Result index (Integer userId) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok(new String("Sample Feed List"));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Error in processing feed list"));
        }

    }

    public static Result read(Integer id) {
        try {
            // Feed currentFeed = new List(FeedDao.find(id))
            // gson.toJson(currentFeed)
            return ok(new String("Finding feed with  id " + id));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Research on feed item failed"));
        }
    }

    public static Result update(Integer id) {
        return ok("updating a subscription");
    }
    public static  Result getFeedTitles(Integer id, Integer fid) {
        return ok("Trying to get the titles of all articles");
    }

    public static Result reloadFeeds(Integer id) {
        return ok("Reload feeds...");
    }

    public static Result getArticle(Integer id, Integer fid) {
        return ok("get Integer calld");
    }

    public static Result markAsRead(Integer id, Integer fid) {
        return ok("Marking article as read");
    }

    public static Result markAsUnRead(Integer id, Integer fid) {
        return ok("Marking an article as unread");
    }
}
