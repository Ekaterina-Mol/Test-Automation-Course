package org.It_Academy.ParsersHomework.model;

import java.util.List;

public class Journal {
    private String title;
    private Contacts contacts;
    private List<Article> articles;

    public String getTitle() {
        return title;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal\n{\n" +
                " title='" + title + '\'' +
                ",\n contacts= " + contacts +
                ",\n articles= " + articles.toString().replace("},","},\n") +
                "\n}";
    }
}
