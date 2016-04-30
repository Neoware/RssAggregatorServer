package models;

import java.io.Serializable;

/**
 * Created by Neoware on 30/04/16 for Project RssAggregatorServer.
 */
public class HeaderSubscription implements Serializable{
    private String name;
    private String url;
    private int feedId;

    public HeaderSubscription(String _name, String _url, int _feedId){
        name = _name;
        url = _url;
        feedId = _feedId;
    }

    @Override
    public String toString() {
        return "HeaderSubscription{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", feedId=" + feedId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
