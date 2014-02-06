package ua.kpi.xml_imp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.kpi.tariff.CallPrices;
import ua.kpi.tariff.Tariff;

public class DOMParser {

    public ArrayList<Tariff> getAllTariffs() {
        try {
            ArrayList<Tariff> tariffs = new ArrayList<>();
            File xmlFile = new File("tariffs.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("tariff");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Tariff tariff = new Tariff();
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (!(eElement.getAttribute("id") == null)) {
                        tariff.setId(eElement.getAttribute("id"));
                    }
                    tariff.setName(getTagValue("name", eElement).trim());
                    tariff.setOperatorName(getTagValue("oname", eElement).trim());
                    tariff.setPayroll(Integer.parseInt(getTagValue("payroll", eElement).trim()));
                    tariff.setSmsPrice(Integer.parseInt(getTagValue("smsprice", eElement).trim()));

                    CallPrices callprice = new CallPrices();
                    callprice.setHomePrice(Integer.parseInt(getTagValue("homep", eElement).trim()));
                    callprice.setInnerPrice(Integer.parseInt(getTagValue("innerp", eElement).trim()));
                    callprice.setOuterPrice(Integer.parseInt(getTagValue("outerp", eElement).trim()));

                    tariff.setCallPrice(callprice);
                    tariffs.add(tariff);
                }
            }
            return tariffs;
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(DOMParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }
}
