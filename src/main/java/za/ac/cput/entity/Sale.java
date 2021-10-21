/*
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */
package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Sale implements Serializable {

    @Id
    private String saleId;
    private String staffId;
    private String saleTotal;
    private String saleDate;

    public Sale(){

    }

    private Sale(Builder builder){
        this.saleId = builder.saleId;
        this.staffId = builder.staffId;
        this.saleTotal = builder.saleTotal;
        this.saleDate = builder.saleDate;
    }

    @Override
    public String toString(){
        return "Sale{ " +
                "saleId: " + saleId + "," +
                "staffId: " + staffId + "," +
                "saleTotal: " + saleTotal + "," +
                "saleDate: " + saleDate +
                "}";
    }

    public String getSaleId() {
        return saleId;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getSaleTotal() {
        return saleTotal;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public static class Builder{
        private String saleId, staffId, saleTotal, saleDate;

        public Builder setSaleId(String saleId) {
            this.saleId = saleId;
            return this;
        }

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setSaleTotal(String saleTotal) {
            this.saleTotal = saleTotal;
            return this;
        }

        public Builder setSaleDate(String saleDate) {
            this.saleDate = saleDate;
            return this;
        }

        public Sale build(){
            return new Sale(this);
        }

        public Builder copy(Sale sale){
            this.saleId = sale.saleId;
            this.staffId = sale.staffId;
            this.saleTotal = sale.saleTotal;
            this.saleDate = sale.saleDate;

            return this;
        }
    }
}
