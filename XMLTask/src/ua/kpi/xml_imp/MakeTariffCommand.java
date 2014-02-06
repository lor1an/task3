/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.xml_imp;

import java.util.ArrayList;
import ua.kpi.tariff.CallPrices;
import ua.kpi.tariff.Tariff;

/**
 *
 * @author lor1an
 */
public class MakeTariffCommand {

    private ArrayList<Tariff> tarrifs = new ArrayList<>();
    private Tariff tariff = new Tariff();
    private CallPrices callprice = new CallPrices();

    public void onOpenTariffTag(String id) {
        tariff.setId(id);
    }

    public ArrayList<Tariff> onClosedTariffTag(String tag) {
        if (tag.equals(Tags.TARIFF)) {
            tariff.setCallPrice(callprice);
            tarrifs.add(tariff);
            tariff = new Tariff();
            callprice = new CallPrices();
        }
        return tarrifs;
    }

    public void setTariffs(ArrayList<Tariff> tarrifs) {
        this.tarrifs = tarrifs;
    }

    public ArrayList<Tariff> getTariffs() {
        return tarrifs;
    }

    public Tariff updateTariff(String tag, String data) {
        if (tag.equals(Tags.TARIFF)) {
        }
        if (tag.equals(Tags.NAME)) {
            tariff.setName(data.trim());
        }
        if (tag.equals(Tags.ONAME)) {
            tariff.setOperatorName(data.trim());
        }
        if (tag.equals(Tags.PAYROLL)) {
            tariff.setPayroll(Integer.parseInt(data.trim()));
        }
        if (tag.equals(Tags.SMSPRICE)) {
            tariff.setSmsPrice(Integer.parseInt(data.trim()));
        }

        if (tag.equals(Tags.INNERP)) {
            callprice.setInnerPrice(Integer.parseInt(data.trim()));
        }
        if (tag.equals(Tags.OUTERP)) {
            callprice.setOuterPrice(Integer.parseInt(data.trim()));
        }
        if (tag.equals(Tags.HOMEP)) {
            callprice.setHomePrice(Integer.parseInt(data.trim()));
        }       
        return tariff;
    }
}
