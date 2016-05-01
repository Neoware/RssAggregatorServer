package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Neoware on 30/04/16 for Project RssAggregatorServer.
 */
public class FeedService {
    UserDao userDao;
    UserArticleDao userArticleDao;
    FeedArticleDao feedArticleDao;


    public FeedService(){
        userDao = new UserDao();
        userArticleDao = new UserArticleDao();
        feedArticleDao = new FeedArticleDao();
    }

    public void MarkAsRead(String username, int articleId) throws Exception {
        User temp = userDao.findUserByUsername(username);
        UserArticle toUpdate = userArticleDao.findByUserAndArticleId(temp.getId(), articleId);
        if (toUpdate != null){
            userArticleDao.updateArticleAsRead(toUpdate);
        }
        else{
            throw new Exception("Not one of the user article, can\'t update read status to read");
        }
    }

    public void MarkAsUnread(String username, int articleId) throws Exception {
        User temp = userDao.findUserByUsername(username);
        UserArticle toUpdate = userArticleDao.findByUserAndArticleId(temp.getId(), articleId);
        if (toUpdate != null){
            userArticleDao.updateArticleAsUnread(toUpdate);
        }
        else{
            throw new Exception("Not one of the user article, can\'t update read status to unread");
        }
    }

    public List<HeaderArticle> GetAllHeaderForAllFeed(String username){
        List<HeaderArticle> headerArticles = new ArrayList<>();
        User temp = userDao.findUserByUsername(username);
        List <UserArticle> userArticles =  temp.getUserArticles();
        Iterator<UserArticle> i = userArticles.iterator();
        while (i.hasNext()) {
            UserArticle userArticle = i.next();
            HeaderArticle toAdd = new HeaderArticle(userArticle.getFeedArticle().getId(), userArticle.isRead(), userArticle.getFeedArticle().getTitle());
            headerArticles.add(toAdd);
        }
    return headerArticles;
    }

    public List<HeaderArticle> GetAllHeaderForOneFeed(String username, int feedId){
        List<HeaderArticle> headerArticles = new ArrayList<>();
        User temp = userDao.findUserByUsername(username);
        List <UserArticle> userArticles =  temp.getUserArticles();
        Iterator<UserArticle> i = userArticles.iterator();
        while (i.hasNext()) {
            UserArticle userArticle = i.next();
            if (userArticle.getFeedArticle().getFeed().getId() == feedId) {
                HeaderArticle toAdd = new HeaderArticle(userArticle.getFeedArticle().getId(), userArticle.isRead(), userArticle.getFeedArticle().getTitle());
                headerArticles.add(toAdd);
            }
        }
        return headerArticles;
    }
    public HeaderArticle GetHeaderForOneArticle(String username, int articleId){
        User temp = userDao.findUserByUsername(username);
        UserArticle userArticle;
        userArticle = userArticleDao.findByUserAndArticleId(temp.getId(), articleId);
        if (userArticle != null && temp != null){
            HeaderArticle headerArticle = new HeaderArticle(userArticle.getFeedArticle().getId(), userArticle.isRead(), userArticle.getFeedArticle().getTitle());
            return headerArticle;
        }
        else
            return null;
    }

    public List <FeedArticle> GetContentForAllFeed(String username){
        List<FeedArticle> feedArticles = new ArrayList<>();
        User temp = userDao.findUserByUsername(username);
        List <UserArticle> userArticles =  temp.getUserArticles();
        Iterator<UserArticle> i = userArticles.iterator();
        while (i.hasNext()) {
            UserArticle userArticle = i.next();
            userArticle.getFeedArticle().getFeed().getId();
                FeedArticle toAdd = userArticle.getFeedArticle();
                feedArticles.add(toAdd);

        }
        return feedArticles;
    }

    public List <FeedArticle> GetContentForOneFeed(String username, int feedId){
        List<FeedArticle> feedArticles = new ArrayList<FeedArticle>();
        User temp = userDao.findUserByUsername(username);
        List <UserArticle> userArticles =  temp.getUserArticles();
        Iterator<UserArticle> i = userArticles.iterator();
        while (i.hasNext()) {
            UserArticle userArticle = i.next();
            if (userArticle.getFeedArticle().getFeed().getId() == feedId) {
                FeedArticle toAdd = userArticle.getFeedArticle();
                feedArticles.add(toAdd);
            }
        }
        return feedArticles;
    }

    public FeedArticle GetContentForOneArticle(String username, int articleId){
        User temp = userDao.findUserByUsername(username);
        UserArticle userArticle = userArticleDao.findByUserAndArticleId(temp.getId(), articleId);
        if (userArticle != null && temp != null){
            userArticle.getFeedArticle().getFeed().getId();
            FeedArticle feedArticle = userArticle.getFeedArticle();
            return feedArticle;
        }
        else
            return null;
    }

}
