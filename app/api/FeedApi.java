package api;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Neti on 13/04/2016.
 */

public class FeedApi extends Controller {
    public Result index (Integer userId) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok(new String("Sample Feed List"));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Error in processing feed list"));
        }

    }

    public Result subscribe(String url) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok(new String("Succesfully subscribed"));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Error while subscribing to feed url"));
        }

    }

    public Result unsubscribe(String url) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok(new String("Succesfully unsubscribed"));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest(new String("Error while unsubscribing to feed url"));
        }
    }

    public Result markAsRead(Integer fid) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Article marked as read");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in marking article");
        }
    }

    public Result markAsUnRead(Integer fid) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Article marked as unread");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in marking article");
        }
    }

    public Result getTitles() {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Sample Feed List");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getFeedTitles(Integer fid) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Sample Feed List");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getFeedArticles (Integer fid) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Sample Feed List");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }

    }

    public Result getArticles() {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Getting");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getArticle(Integer articleId) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Getting");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getArticleTitle (Integer articleId) {
        try {
            // List feedList = new List(FeedDao.findAll())
            // gson.toJson(feedList)
            return ok("Getting");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getSubscriptions () {
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
