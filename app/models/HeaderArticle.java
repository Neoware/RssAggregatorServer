package models;

/**
 * Created by Neoware on 30/04/16 for Project RssAggregatorServer.
 */
public class HeaderArticle {
    private boolean status;
    private String title;

    HeaderArticle(boolean _status, String _title){
        status = _status;
        title = _title;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
