package org.It_Academy.ParsersHomework.parsers.dom;

import org.It_Academy.ParsersHomework.model.Article;
import org.It_Academy.ParsersHomework.model.Contacts;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class ArticleParser {
    public List<Article> parse(NodeList nodeList){
        List<Article> articles = new ArrayList<>();

        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                Article article = new Article();
                article.setID(node.getAttributes().
                        getNamedItem("ID").getNodeValue());
                NodeList childNodes = node.getChildNodes();
                DOMParserUtils.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        this.parse(article, childNode);
                    }
                });

                articles.add(article);
            }
        });

        return articles;
    }

    private Article parse(Article article, Node node){
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "title":
                article.setTitle(content);
                break;
            case "author":
                article.setAuthor(content);
                break;
            case "url":
                article.setUrl(content);
                break;
            case "hotkeys":
                article.setHotkeys(this.parseHotkeys(node.getChildNodes()));
                break;
        }
        return article;
    }

    private List<String> parseHotkeys(NodeList nodeList) {
        List<String> hotkeys = new ArrayList<>();
        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                hotkeys.add(node.getLastChild()
                        .getTextContent()
                        .trim());
            }
        });

        return hotkeys;
    }
}
