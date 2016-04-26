package modules;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.XmlReader;
import play.Logger;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import com.sun.syndication.io.SyndFeedInput;


public class RssReader {
    public void verify() throws Exception {
        try {
            URL url = new URL("http://feeds.feedburner.com/manishchhabra27");
            HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
    }

    public void read(String url) throws Exception {
        try {
            URL currentUrl = new URL(url);
            HttpURLConnection httpcon = (HttpURLConnection)currentUrl.openConnection();
            // Reading the feed

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(httpcon));
            List entries = feed.getEntries();
            Iterator itEntries = entries.iterator();

            while (itEntries.hasNext()) {
                SyndEntry entry = (SyndEntry) itEntries.next();
                System.out.println("Title: " + entry.getTitle());
                System.out.println("Link: " + entry.getLink());
                System.out.println("Author: " + entry.getAuthor());
                System.out.println("Publish Date: " + entry.getPublishedDate());
                System.out.println("Description: " + entry.getDescription().getValue());
                System.out.println();
            }
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }

    }

    public void update(String url) throws Exception {
        try {
            URL currentUrl = new URL(url);
            HttpURLConnection httpcon = (HttpURLConnection)currentUrl.openConnection();
            // Reading the feed

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(httpcon));
            List entries = feed.getEntries();
            Iterator itEntries = entries.iterator();

            while (itEntries.hasNext()) {
                SyndEntry entry = (SyndEntry) itEntries.next();
                System.out.println("Title: " + entry.getTitle());
                System.out.println("Link: " + entry.getLink());
                System.out.println("Author: " + entry.getAuthor());
                System.out.println("Publish Date: " + entry.getPublishedDate());
                System.out.println("Description: " + entry.getDescription().getValue());
                System.out.println();
            }
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }

    }
}