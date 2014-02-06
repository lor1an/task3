/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.tariff;

import java.util.Objects;

/**
 *
 * @author lor1an
 */
public class Tariff {

    private String id;
    private String name;
    private String operatorName;
    private int payroll;
    private CallPrices callPrice;
    private int smsPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public int getPayroll() {
        return payroll;
    }

    public CallPrices getCallPrice() {
        return callPrice;
    }

    public int getSmsPrice() {
        return smsPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }

    public void setCallPrice(CallPrices callPrice) {
        this.callPrice = callPrice;
    }

    public void setSmsPrice(int smsPrice) {
        this.smsPrice = smsPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.operatorName);
        hash = 79 * hash + this.payroll;
        hash = 79 * hash + Objects.hashCode(this.callPrice);
        hash = 79 * hash + this.smsPrice;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tariff other = (Tariff) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.operatorName, other.operatorName)) {
            return false;
        }
        if (this.payroll != other.payroll) {
            return false;
        }
        if (!Objects.equals(this.callPrice, other.callPrice)) {
            return false;
        }
        if (this.smsPrice != other.smsPrice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tariff{" + "name=" + name + ", operatorName=" + operatorName + ", payroll=" + payroll + ", callPrice=" + callPrice + ", smsPrice=" + smsPrice + '}';
    }
}
