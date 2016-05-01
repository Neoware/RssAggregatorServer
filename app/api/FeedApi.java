package api;

import com.google.gson.Gson;
import models.*;
import modules.RssReader;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static api.UserApi.verifyAuth;

public class FeedApi extends Controller {

    public Result update(String url) {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            RssReader rss = new RssReader();
            rss.update(url);
            return ok("Succesfully updated");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error while updating the feed");
        }

    }

    public Result subscribe(String url) {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            SubscriptionService service = new SubscriptionService();
            service.Subscribe(cUser.getUsername(), url);
            return ok("Succesfully subscribed");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error while subscribing to feed url");
        }

    }

    public Result unsubscribe(String url) {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            SubscriptionService service = new SubscriptionService();
            service.Unsubscribe(cUser.getUsername(), url);
            return ok("Succesfully unsubscribed");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error while unsubscribing to feed url");
        }
    }

    public Result markAsRead(Integer fid) {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            FeedService service = new FeedService();
            service.MarkAsRead(cUser.getUsername(), fid);
            return ok("Article marked as read");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in marking article");
        }
    }

    public Result markAsUnRead(Integer fid) {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            FeedService service = new FeedService();
            service.MarkAsUnread(cUser.getUsername(), fid);
            return ok("Article marked as unread");
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in marking article");
        }
    }

    public Result getTitles() {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            FeedService service = new FeedService();
            List result = service.GetAllHeaderForAllFeed(cUser.getUsername());
            Gson gson = new Gson();
            gson.toJson(result);
            return ok(gson.toJson(result));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getFeedTitles(Integer fid) {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            FeedService service = new FeedService();
            List result = service.GetAllHeaderForOneFeed(cUser.getUsername(), fid);
            Gson gson = new Gson();
            gson.toJson(result);
            return ok(gson.toJson(result));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getFeedArticles (Integer fid) {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            FeedService service = new FeedService();
            List result = service.GetContentForOneFeed(cUser.getUsername(), fid);
            Gson gson = new Gson();
            gson.toJson(result);
            return ok(gson.toJson(result));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }

    }

    public Result getArticles() {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            FeedService service = new FeedService();
            List result = service.GetContentForAllFeed(cUser.getUsername());
            Gson gson = new Gson();
            gson.toJson(result);
            return ok(gson.toJson(result));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getArticle(Integer articleId) {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            FeedService service = new FeedService();
            FeedArticle result = service.GetContentForOneArticle(cUser.getUsername(), articleId);
            Gson gson = new Gson();
            gson.toJson(result);
            return ok(gson.toJson(result));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getArticleTitle (Integer articleId) {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            FeedService service = new FeedService();
            HeaderArticle result = service.GetHeaderForOneArticle(cUser.getUsername(), articleId);
            Gson gson = new Gson();
            gson.toJson(result);
            return ok(gson.toJson(result));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }

    public Result getSubscriptions () {
        try {
            User cUser = verifyAuth(request().getHeader("authentication"));
            if (cUser == null) {
                return unauthorized();
            }
            SubscriptionService service = new SubscriptionService();
            List result = service.GetSubscriptions(cUser.getUsername());
            Gson gson = new Gson();
            gson.toJson(result);
            return ok(gson.toJson(result));
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return badRequest("Error in processing feed list");
        }
    }
}
