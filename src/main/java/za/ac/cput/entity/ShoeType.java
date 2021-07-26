/*  ShoeType.java
    Entity for the ShoeType
    Author: Michael Benjamin (219071438)
    Date: 09 June 2021
 */

package za.ac.cput.entity;

public class ShoeType {

    private String shoeTypeId, colour;
    private double price;

    private ShoeType(ShoeType.Builder builder){
        this.shoeTypeId = builder.shoeTypeId;
        this.colour = builder.colour;
        this.price = builder.price;

    }

    @Override
    public String toString() {
        return "ShoeType{" +
                "shoeTypeId='" + shoeTypeId + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                '}';
    }

    public String getShoeTypeId() {
        return shoeTypeId;
    }

    public String getColour() {
        return colour;
    }

    public double getPrice() {
        return price;
    }

    public static class Builder{

        private String shoeTypeId, colour;
        private double price;

        public ShoeType.Builder setShoeTypeId(String shoeTypeId) {
            this.shoeTypeId = shoeTypeId;
            return this;
        }

        public ShoeType.Builder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public ShoeType.Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ShoeType build(){
            return new ShoeType(this);
        }

        public ShoeType.Builder copy(ShoeType shoeType){
            this.shoeTypeId = shoeType.shoeTypeId;
            this.colour = shoeType.colour;
            this.price = shoeType.price;

            return this;

        }

    }
}
