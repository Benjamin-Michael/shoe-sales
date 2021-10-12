/*  Shoe.java
    Entity for the Shoe
    Author: Michael Benjamin (219071438)
    Date: 08 June 2021
 */

package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Shoe implements Serializable {

    @Id
    private String shoeId;
    private String brand, modelId, shoeTypeId, shoeSizeId;

    public Shoe(){}

    public String getShoeId() {
        return shoeId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelId() {
        return modelId;
    }

    public String getShoeTypeId() {
        return shoeTypeId;
    }

    public String getShoeSizeId() {
        return shoeSizeId;
    }

    private Shoe(Builder builder){
        this.shoeId = builder.shoeId;
        this.brand = builder.brand;
        this.modelId = builder.modelId;
        this.shoeTypeId = builder.shoeTypeId;
        this.shoeSizeId = builder.shoeSizeId;

    }

    @Override
    public String toString() {
        return "Shoe{" +
                "shoeId='" + shoeId + '\'' +
                ", brand='" + brand + '\'' +
                ", modelId='" + modelId + '\'' +
                ", shoeTypeId='" + shoeTypeId + '\'' +
                ", shoeSizeId='" + shoeSizeId + '\'' +
                '}';
    }

    public static class Builder{

        private String shoeId, brand, modelId, shoeTypeId, shoeSizeId;

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

        public Builder setShoeTypeId(String shoeTypeId) {
            this.shoeTypeId = shoeTypeId;
            return this;
        }

        public Builder setShoeSizeId(String shoeSizeId) {
            this.shoeSizeId = shoeSizeId;
            return this;
        }

        public Shoe build(){
            return new Shoe(this);
        }

        public Builder copy(Shoe shoe){
            this.shoeId = shoe.shoeId;
            this.brand = shoe.brand;
            this.modelId = shoe.modelId;
            this.shoeTypeId = shoe.shoeTypeId;
            this.shoeSizeId = shoe.shoeSizeId;

            return this;

        }

    }

}
