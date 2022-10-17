package org.It_Academy.ParsersHomework.parsers.stax;

import org.It_Academy.ParsersHomework.model.Article;
import org.It_Academy.ParsersHomework.model.Contacts;
import org.It_Academy.ParsersHomework.model.Journal;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class STAXParser {
    private XMLStreamReader reader = null;

    public Journal parse(String path) throws XMLStreamException {
        Journal journal = null;
        String tagContent = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        reader =
                factory.createXMLStreamReader(
                        ClassLoader.getSystemResourceAsStream(path));


        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "journal":
                            journal = new Journal();
                            break;
                        case "contacts":
                            journal.setContacts(this.parseContacts());
                            break;
                        case "articles":
                            journal.setArticles(this.parseArticles());
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "title":
                            journal.setTitle(tagContent);
                            break;
                    }
                    break;
            }
        }

        return journal;
    }

    private Contacts parseContacts() throws XMLStreamException {
        Contacts contacts = new Contacts();
        String tagContent = null;
        boolean isNodeEnded = false;

        while (reader.hasNext() && !isNodeEnded) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "address":
                            contacts.setAddress(tagContent);
                            break;
                        case "url":
                            contacts.setUrl(tagContent);
                            break;
                        case "email":
                            contacts.setEmail(tagContent);
                            break;
                        case "tel":
                            contacts.setTel(tagContent);
                            break;
                        case "contacts":
                            isNodeEnded = true;
                            break;
                    }
                    break;
            }

        }
        return contacts;
    }

    private List<Article> parseArticles() throws XMLStreamException {
        List<Article> articles = new ArrayList<Article>();
        List<String> hotkeys = null;
        Article currentArticle = null;
        String tagContent = null;

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "article":
                            currentArticle = new Article();
                            currentArticle.setID(reader.getAttributeValue(0));
                            break;
                        case "hotkeys":
                            hotkeys = new ArrayList<String>();
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "article":
                            articles.add(currentArticle);
                            break;
                        case "title":
                            currentArticle.setTitle(tagContent);
                            break;
                        case "author":
                            currentArticle.setAuthor(tagContent);
                            break;
                        case "url":
                            currentArticle.setUrl(tagContent);
                            break;
                        case "hotkey":
                            hotkeys.add(tagContent);
                            break;
                        case "hotkeys":
                            currentArticle.setHotkeys(hotkeys);
                            break;
                    }
                    break;
            }
        }
        return articles;
    }
}
