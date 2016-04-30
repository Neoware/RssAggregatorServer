package models;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Neoware on 27/04/16 for Project RssAggregatorServer.
 */
public class SubscriptionService {

    private UserDao userDao;
    private FeedDao feedDao;
    private UserSubscriptionDao userSubscriptionDao;

    public SubscriptionService(){
        userDao = new UserDao();
        feedDao = new FeedDao();
        userSubscriptionDao = new UserSubscriptionDao();
    }


    public boolean Subscribe(String username, String url){
        User tempUser = userDao.findUserByUsername(username);
        Feed tempFeed = feedDao.findByUrl(url);
        if (tempFeed == null){
            //TODO check if rss feed is correct
            if (true) {
                feedDao.Create(url);
                tempFeed = feedDao.findByUrl(url);
            }
            else {
                System.out.println("Bad rss");
                return false;
            }
        }
        else {
            if (userSubscriptionDao.findByUserAndFeed(tempUser, tempFeed) !=  null) {
                System.out.println("Already subscribe");
                return false;
            }
        }
        userSubscriptionDao.createSubscription(tempUser, tempFeed);
        return true;
    }

    public boolean Unsubscribe(String username, String url){
        User tempUser = userDao.findUserByUsername(username);
        Feed tempFeed = feedDao.findByUrl(url);
        if (tempFeed == null){
            System.out.println("This feed doesn't exist");
            return false;
        }
        UserSubscription subscription = userSubscriptionDao.findByUserAndFeed(tempUser, tempFeed);
        if (subscription !=  null) {
            userSubscriptionDao.deleteSubscription(subscription);
            List <UserArticle> userArticles = tempUser.getUserArticles();

            Iterator<UserArticle> i = userArticles.iterator();
            while (i.hasNext()) {
                UserArticle userArticle = i.next();
                if (userArticle.getFeedArticle().getFeed().getId() == tempFeed.getId())
                i.remove();
            }
            tempUser.setUserArticles(userArticles);
            userDao.updateUser(tempUser);
            return true;
        }
        else {
            System.out.println("This user is already not subscribed to this url");
            return false;
        }

    }


}
