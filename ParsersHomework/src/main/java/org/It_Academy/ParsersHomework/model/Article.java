package org.It_Academy.ParsersHomework.model;

import java.util.List;

public class Article {
    private String ID;
    private String title;
    private String author;
    private String url;
    private List<String> hotkeys;

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getHotkeys() {
        return hotkeys;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHotkeys(List<String> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return "{" +
                "ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkeys=" + hotkeys +
                "}";
    }
}
