/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.tariff;

/**
 *
 * @author lor1an
 */
public class CallPrices {

    private int innerPrice;
    private int outerPrice;
    private int homePrice;

    public int getInnerPrice() {
        return innerPrice;
    }

    public int getOuterPrice() {
        return outerPrice;
    }

    public int getHomePrice() {
        return homePrice;
    }

    public void setInnerPrice(int priceInNetwork) {
        this.innerPrice = priceInNetwork;
    }

    public void setOuterPrice(int pricerOutNetwork) {
        this.outerPrice = pricerOutNetwork;
    }

    public void setHomePrice(int priceHomePhones) {
        this.homePrice = priceHomePhones;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.innerPrice;
        hash = 41 * hash + this.outerPrice;
        hash = 41 * hash + this.homePrice;
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
        final CallPrices other = (CallPrices) obj;
        if (this.innerPrice != other.innerPrice) {
            return false;
        }
        if (this.outerPrice != other.outerPrice) {
            return false;
        }
        if (this.homePrice != other.homePrice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CallPrices{" + "priceInNetwork=" + innerPrice + ", pricerOutNetwork=" + outerPrice + ", priceHomePhones=" + homePrice + '}';
    }
    
}
