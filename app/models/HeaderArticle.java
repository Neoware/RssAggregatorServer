package models;

import java.io.Serializable;

/**
 * Created by Neoware on 30/04/16 for Project RssAggregatorServer.
 */
public class HeaderArticle implements Serializable{
    private int id;
    private boolean status;
    private String title;

    HeaderArticle(int _id, boolean _status, String _title){
        id = _id;
        status = _status;
        title = _title;
    }

    @Override
    public String toString() {
        return "HeaderArticle{" +
                "id=" + id +
                ", status=" + status +
                ", title='" + title + '\'' +
                '}';
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
