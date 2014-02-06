/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.xml_imp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import ua.kpi.tariff.Tariff;

/**
 *
 * @author lor1an
 */
public class StAXParser {

    public ArrayList<Tariff> getAllTariffs() {
        MakeTariffCommand createCommand = new MakeTariffCommand();
        ArrayList<Tariff> tariffs = createCommand.getTariffs();
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream("tariffs.xml");
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if (startElement.getAttributeByName(new QName("id")) != null) {
                        createCommand.onOpenTariffTag(startElement.getAttributeByName(new QName("id")).getValue());
                    }
                    String tag = event.asStartElement().getName().getLocalPart();
                    event = eventReader.nextEvent();
                    createCommand.updateTariff(tag, event.asCharacters().getData());
                    continue;
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    createCommand.onClosedTariffTag(endElement.getName().getLocalPart());
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return tariffs;
    }
}
