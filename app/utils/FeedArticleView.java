package utils;

import models.Feed;
import models.UserArticle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FeedArticleView implements Serializable {
    public int id;
    public String title;
    public String content;
    public Feed feed;
    public List<UserArticle> userArticles = new ArrayList<>();
}
