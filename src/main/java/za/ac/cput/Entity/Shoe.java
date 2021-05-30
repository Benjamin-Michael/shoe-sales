package za.ac.cput.Entity;

public class Shoe {

    private String shoeId, brand, colour;
    private int size;
    private double price;

    private Shoe(Builder builder){
        this.shoeId = builder.shoeId;
        this.brand = builder.brand;
        this.colour = builder.colour;
        this.size = builder.size;
        this.price = builder.price;

    }

    @Override
    public String toString() {
        return "Shoe{" +
                "shoeId='" + shoeId + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }

    public static class Builder{

        private String shoeId, brand, colour;
        private int size;
        private double price;

        public Builder setShoeId(String shoeId) {
            this.shoeId = shoeId;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Shoe build(){
            return new Shoe(this);
        }

        public Builder copy(Shoe shoe){
            this.shoeId = shoe.shoeId;
            this.brand = shoe.brand;
            this.colour = shoe.colour;
            this.size = shoe.size;
            this.price = shoe.price;

            return this;

        }

    }

}
