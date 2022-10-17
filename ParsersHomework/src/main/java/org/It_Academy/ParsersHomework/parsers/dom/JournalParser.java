package org.It_Academy.ParsersHomework.parsers.dom;

import org.It_Academy.ParsersHomework.model.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JournalParser {
    private final ContactsParser contactsParser;
    private final ArticleParser articleParser;

    public JournalParser() {
        this.contactsParser = new ContactsParser();
        this.articleParser = new ArticleParser();
    }

    public Journal parse(String path) {
        Document document = DOMParserUtils.parseXMLDocument(path);
        NodeList nodeList = DOMParserUtils.getNodeList(document);

        return this.parse(nodeList);
    }

    private Journal parse(NodeList nodeList) {
        Journal journal = new Journal();
        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                        this.parse(journal, node);
            }
        });

        return journal;
    }

    private Journal parse(Journal journal, Node node){
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "title":
                journal.setTitle(content);
                break;
            case "contacts":
                journal.setContacts(this.contactsParser.parse(node.getChildNodes()));
                break;
            case "articles":
                journal.setArticles(this.articleParser.parse(node.getChildNodes()));
                break;
        }
        return journal;
    }
}
