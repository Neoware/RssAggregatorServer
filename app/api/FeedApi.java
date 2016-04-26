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

    public static Result subscribe(String url) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok(new String("Succesfully subscribed"));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Error while subscribing to feed url"));
        }

    }

    public static Result unsubscribe(String url) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok(new String("Succesfully unsubscribed"));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Error while unsubscribing to feed url"));
        }
    }

    public static Result markAsRead(Integer id, Integer fid) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Article marked as read");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in marking article");
        }
    }

    public static Result markAsUnRead(Integer fid) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Article marked as unread");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in marking article");
        }
    }

    public static  Result getFeedTitles(Integer fid) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Sample Feed List");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public static Result getFeedArticles (Integer fid) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Sample Feed List");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }

    }

    public static Result getArticle(Integer articleId) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Getting");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public static Result getArticleTitle (Integer articleId) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Getting");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public static Result getSubscriptions () {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Sample Feed List");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }

    }
}
