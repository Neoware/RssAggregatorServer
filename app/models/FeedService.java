package models;

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

    public void MarkAsRead(String username, int articleId){
        User temp = userDao.findUserByUsername(username);
        UserArticle toUpdate = userArticleDao.findByUserAndArticleId(temp.getId(), articleId);
        if (toUpdate != null){
            userArticleDao.updateArticleAsRead(toUpdate);
        }
        else{
            System.out.println("Not one of the user article, can\'t update read status to read");
        }
    }

    public void MarkAsUnread(String username, int articleId){
        User temp = userDao.findUserByUsername(username);
        UserArticle toUpdate = userArticleDao.findByUserAndArticleId(temp.getId(), articleId);
        if (toUpdate != null){
            userArticleDao.updateArticleAsUnread(toUpdate);
        }
        else{
            System.out.println("Not one of the user article, can\'t update read status to unread");
        }
    }

}
