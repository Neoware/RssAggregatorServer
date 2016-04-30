package models;

/**
 * Created by Neoware on 30/04/16 for Project RssAggregatorServer.
 */
public class HeaderSubscription {
    private String name;
    private String url;

    public HeaderSubscription(String _name, String _url){
        name = _name;
        url = _url;
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
