package org.It_Academy.ParsersHomework.parsers.dom;

import org.It_Academy.ParsersHomework.model.Contacts;
import org.It_Academy.ParsersHomework.model.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ContactsParser {
    public Contacts parse(NodeList nodeList) {
        Contacts contacts = new Contacts();
        DOMParserUtils.getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                if (node instanceof Element) {
                    this.parse(contacts, node);
                }
            }
        });

        return contacts;
    }

    private Contacts parse(Contacts contacts, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "address":
                contacts.setAddress(content);
                break;
            case "email":
                contacts.setEmail(content);
                break;
            case "url":
                contacts.setUrl(content);
                break;
            case "tel":
                contacts.setTel(content);
                break;
        }
        return contacts;
    }
}
