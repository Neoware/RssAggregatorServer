package models;

import modules.RssReader;
import org.apache.commons.codec.binary.Base64;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Neoware on 27/04/16 for Project RssAggregatorServer.
 */
public class SubscriptionService {

    private UserDao userDao;
    private FeedDao feedDao;
    private UserSubscriptionDao userSubscriptionDao;
    private RssReader rssReader;

    public SubscriptionService(){
        userDao = new UserDao();
        feedDao = new FeedDao();
        userSubscriptionDao = new UserSubscriptionDao();
        rssReader = new RssReader();
    }


    public void Subscribe(String username, String url) throws Exception {
        User tempUser = userDao.findUserByUsername(username);
        Feed tempFeed = feedDao.findByUrl(url);
            if (tempFeed == null){
                try {
                    if (RssReader.verify(url)) {
                        rssReader.read(url, tempUser.getId());

                        tempFeed = feedDao.findByUrl(url);
                    }
                    else {
                        throw new Exception("Bad rss verify");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Exception("throw verify");
                }
            }
            else {
                if (userSubscriptionDao.findByUserAndFeed(tempUser, tempFeed) !=  null) {
                    throw new Exception("Already subscribe");
                }
            }
            userSubscriptionDao.createSubscription(tempUser, tempFeed);

    }

    public void Unsubscribe(String username, String url) throws Exception {
        User tempUser = userDao.findUserByUsername(username);
        Feed tempFeed = feedDao.findByUrl(url);
        if (tempFeed == null){
            throw new Exception("This feed doesn't exist");
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
        }
        else {
            throw new Exception("This user is already not subscribed to this url");
        }

    }

    public List<HeaderSubscription> GetSubscriptions(String username){
        User tempUser = userDao.findUserByUsername(username);
        List <HeaderSubscription> headerSubscriptions = new ArrayList<>();

        List <UserSubscription> userSubscriptions = tempUser.getUserSubscriptions();

        Iterator<UserSubscription> i = userSubscriptions.iterator();
        while (i.hasNext()) {
            UserSubscription userSubscription = i.next();
            HeaderSubscription toAdd = new HeaderSubscription(userSubscription.getFeed().getName(), new String(Base64.decodeBase64(userSubscription.getFeed().getUrl())), userSubscription.getFeed().getId());
            headerSubscriptions.add(toAdd);
        }
        return headerSubscriptions;
    }


}
