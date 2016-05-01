package modules;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.XmlReader;
import models.*;
import org.apache.commons.codec.binary.Base64;
import play.Logger;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.List;
import com.sun.syndication.io.SyndFeedInput;


public class RssReader {

    public static Boolean verify(String url) throws Exception {
        try {
            URL currentUrl = new URL(new String(Base64.decodeBase64(url)));
            System.out.println(new String(Base64.decodeBase64(url)));
            HttpURLConnection httpcon = (HttpURLConnection)currentUrl.openConnection();

            if (httpcon == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            Logger.error(e.getMessage());
            return false;
        }
    }

    public void read(String url, Integer userId) throws Exception {
        try {
            URL currentUrl = new URL(new String(Base64.decodeBase64(url)));
            HttpURLConnection httpcon = (HttpURLConnection)currentUrl.openConnection();
            // Reading the feed

            if (httpcon == null) {
                return;
            }

            FeedDao feedDao = new FeedDao();
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(httpcon));
            List entries = feed.getEntries();
            Iterator itEntries = entries.iterator();

            Feed tmp = feedDao.Create(url, feed.getTitle());

            while (itEntries.hasNext()) {
                SyndEntry entry = (SyndEntry) itEntries.next();
                FeedArticleDao faDao = new FeedArticleDao();
                LocalDate date = entry.getPublishedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                FeedArticle fArticle = faDao.Create(entry.getTitle(), entry.getLink(), tmp, entry.getAuthor(), date);

                UserArticleDao uArticle = new UserArticleDao();
                uArticle.Create(userId, fArticle.getId());
            }
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
    }

    public void update(String url) throws Exception {
        try {
            URL currentUrl = new URL(new String(Base64.decodeBase64(url)));
            HttpURLConnection httpcon = (HttpURLConnection)currentUrl.openConnection();
            // Reading the feed

            if (httpcon == null) {
                return;
            }

            FeedDao feedDao = new FeedDao();
            feedDao.Delete(url);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(httpcon));
            List entries = feed.getEntries();
            Iterator itEntries = entries.iterator();

            Feed tmp = feedDao.Create(url, feed.getTitle());

            while (itEntries.hasNext()) {
                SyndEntry entry = (SyndEntry) itEntries.next();
                FeedArticleDao faDao = new FeedArticleDao();
                LocalDate date = entry.getPublishedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                faDao.Create(entry.getTitle(), entry.getLink(), tmp,entry.getAuthor(), date);
            }
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }

    }
}
