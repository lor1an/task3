/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.xsd_valid;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 *
 * @author lor1an
 */
public class XSDValidation {
    public static boolean validate() {
        try {
            File schemaFile = new File("tariffs.xsd");
            Source xmlFile = new StreamSource(new File("tariffs.xml"));
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            try {
                validator.validate(xmlFile);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(XSDValidation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException e) {
                return false;
            }
        } catch (SAXException ex) {
            Logger.getLogger(XSDValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
