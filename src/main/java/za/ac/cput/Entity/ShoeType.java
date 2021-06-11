/*  ShoeType.java
    Entity for the ShoeType
    Author: Michael Benjamin (219071438)
    Date: 09 June 2021
 */

package za.ac.cput.Entity;

public class ShoeType {

    private String colour;
    private double price;

    private ShoeType(ShoeType.Builder builder){
        this.colour = builder.colour;
        this.price = builder.price;

    }

    @Override
    public String toString() {
        return "ShoeType{" +
                "colour='" + colour + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder{

        private String colour;
        private double price;

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
            this.colour = shoeType.colour;
            this.price = shoeType.price;

            return this;

        }

    }
}
