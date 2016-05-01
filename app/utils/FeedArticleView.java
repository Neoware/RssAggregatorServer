package utils;


import com.google.gson.Gson;
import models.FeedArticle;

import java.io.Serializable;
import java.time.LocalDate;



public class FeedArticleView implements Serializable {
    public int id;
    public String title;
    public String content;
    public LocalDate date;
    public String author;

    FeedArticleView(FeedArticle article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.date = article.getPublishedDate();
        this.author = article.getAuthor();
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
