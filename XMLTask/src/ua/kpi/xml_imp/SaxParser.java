/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.xml_imp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.kpi.tariff.Tariff;

/**
 *
 * @author lor1an
 */
public class SaxParser extends DefaultHandler {
        private MakeTariffCommand tarrifCommand = new MakeTariffCommand();
    private ArrayList<Tariff> tariffs = tarrifCommand.getTariffs();
    private String thisElement = "";

 
    public ArrayList<Tariff> getAllTariffs() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            SaxParser saxp = new SaxParser();
            parser.parse(new File("tariffs.xml"), saxp);
            return saxp.tariffs;
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(SaxParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if (!(atts.getQName(0) == null)) {
            tarrifCommand.onOpenTariffTag(atts.getValue(0));
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
        tariffs = tarrifCommand.onClosedTariffTag(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tarrifCommand.updateTariff(thisElement, new String(ch, start, length));
    }

    @Override
    public void endDocument() {
    }
}
