/*
    Author: Faidh Adams 215060148
    Date: 11 June 2021
 */
package za.ac.cput.entity;

public class Return {
    private String returnId, saleId, returnDate;

    private Return(Builder builder){
        this.returnId = builder.returnId;
        this.saleId = builder.saleId;
        this.returnDate = builder.returnDate;
    }

    @Override
    public String toString(){
        return "Return{ " +
                "returnId: " + returnId + "," +
                "saleId: " + saleId + "," +
                "returnDate: " + returnDate +
                "}";
    }

    public String getReturnId() {
        return this.returnId;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public static class Builder{
        private String returnId, saleId, returnDate;

        public Return.Builder setSaleId(String saleId) {
            this.saleId = saleId;
            return this;
        }

        public Return.Builder setReturnId(String returnId) {
            this.returnId = returnId;
            return this;
        }

        public Return.Builder setReturnDate(String returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Return build(){
            return new Return(this);
        }

        public Return.Builder copy(Return returns){
            this.saleId = returns.saleId;
            this.returnId = returns.returnId;
            this.returnDate = returns.returnDate;

            return this;
        }
    }

}
