/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.tariff;

import java.util.ArrayList;
import ua.kpi.xml_imp.DOMParser;
import ua.kpi.xml_imp.SaxParser;
import ua.kpi.xml_imp.StAXParser;
import ua.kpi.xsd_valid.XSDValidation;

/**
 *
 * @author lor1an
 */
public class Runner {

    public static void main(String[] args) {     

        ArrayList<Tariff> tariffs = new DOMParser().getAllTariffs();
        ArrayList<Tariff> saxTariffs = new SaxParser().getAllTariffs();
        ArrayList<Tariff> staxTariffs = new StAXParser().getAllTariffs();
        for (Tariff tariff : tariffs) {
            System.out.println(tariff);
        }
        System.out.println("");
        for (Tariff t : saxTariffs) {
            System.out.println(t);
        }
        System.out.println("");
        for (Tariff t : staxTariffs) {
            System.out.println(t);
        }
         System.out.println(XSDValidation.validate());
    }
}