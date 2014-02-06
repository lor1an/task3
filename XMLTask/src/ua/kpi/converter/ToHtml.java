/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.converter;

import java.io.FileOutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 *
 * @author lor1an
 */
public class ToHtml {
     public void tranformToHTML() {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("tariffs.xsl"));
            transformer.transform(new javax.xml.transform.stream.StreamSource("tariffs.xml"),
                    new javax.xml.transform.stream.StreamResult(new FileOutputStream("tariffs.html")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
