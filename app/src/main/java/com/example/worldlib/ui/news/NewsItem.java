package com.example.worldlib.ui.news;

import java.util.zip.DataFormatException;

public class NewsItem {
    private int id;
    private String url;
    private String title;
    private String body;
    private String author;
    private DataFormatException start;

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public DataFormatException getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
