package za.ac.cput.Entity;

public class Shoe {

    private String shoeId, brand, modelId;

    private Shoe(Builder builder){
        this.shoeId = builder.shoeId;
        this.brand = builder.brand;
        this.modelId = builder.modelId;

    }

    @Override
    public String toString() {
        return "Shoe{" +
                "shoeId='" + shoeId + '\'' +
                ", brand='" + brand + '\'' +
                ", modelId='" + modelId +
                '}';
    }

    public static class Builder{

        private String shoeId, brand, modelId;

        public Builder setShoeId(String shoeId) {
            this.shoeId = shoeId;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setModelId(String modelId) {
            this.modelId = modelId;
            return this;
        }

        public Shoe build(){
            return new Shoe(this);
        }

        public Builder copy(Shoe shoe){
            this.shoeId = shoe.shoeId;
            this.brand = shoe.brand;
            this.modelId = shoe.modelId;

            return this;

        }

    }

}
