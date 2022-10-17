package org.It_Academy.ParsersHomework;

import org.It_Academy.ParsersHomework.model.Journal;
import org.It_Academy.ParsersHomework.parsers.dom.JournalParser;
import org.It_Academy.ParsersHomework.parsers.stax.STAXParser;

import javax.xml.stream.XMLStreamException;

public class Main {
    private static final String XML_PATH = "JournalXMLStructure.xml";
    public static void main(String[] args) throws XMLStreamException {
        var journalParser = new JournalParser();
        Journal journal = journalParser.parse(XML_PATH);

        System.out.println(journal.toString());

        STAXParser staxParser = new STAXParser();

        journal = staxParser.parse(XML_PATH);

        System.out.println(journal.toString());
    }
}