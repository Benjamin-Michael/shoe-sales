/*
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */
package za.ac.cput.entity;

public class SaleItem {

    private String saleItemId, shoeId, saleId;

    private SaleItem(Builder builder){
        this.saleItemId = builder.saleItemId;
        this.saleId = builder.saleId;
        this.shoeId = builder.shoeId;
    }

    @Override
    public String toString(){
        return "SaleItem{" +
                "saleItemId: " + saleItemId + "," +
                "shoeId: " + shoeId + "," +
                "saleId: " + saleId +
                "}";
    }

    public String getSaleItemId() {
        return saleItemId;
    }

    public String getShoeId() {
        return shoeId;
    }

    public String getSaleId() {
        return saleId;
    }

    public static class Builder{
        private String saleItemId, shoeId, saleId;

        public Builder setSaleItemId(String saleItemId) {
            this.saleItemId = saleItemId;
            return this;
        }

        public Builder setShoeId(String shoeId) {
            this.shoeId = shoeId;
            return this;
        }

        public Builder setSaleId(String saleId) {
            this.saleId = saleId;
            return this;
        }

        public SaleItem build() {
            return new SaleItem(this);
        }

        public Builder copy(SaleItem saleItem){
            this.saleItemId = saleItem.saleItemId;
            this.shoeId = saleItem.shoeId;
            this.saleId = saleItem.saleId;

            return this;
        }

    }
}
