package utils;

import models.HeaderArticle;

import java.io.Serializable;

/**
 * Created by Neti on 01/05/2016.
 */
public class HeaderArticleView implements Serializable {
    private int id;
    private boolean status;
    private String title;

    public String toJson(HeaderArticle hArticle) {
        return null;
    }

    public String toJson() {
        return null;
    }
}
