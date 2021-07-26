/*  ShoeSize.java
    Entity for the ShoeSize
    Author: Michael Benjamin (219071438)
    Date: 09 June 2021
 */

package za.ac.cput.entity;

public class ShoeSize {

    private String shoeSizeId;
    private boolean adultSize;
    private int size;

    private ShoeSize(ShoeSize.Builder builder){
        this.shoeSizeId = builder.shoeSizeId;
        this.size = builder.size;
        this.adultSize = builder.adultSize;

    }

    @Override
    public String toString() {
        return "ShoeSize{" +
                "shoeSizeId='" + shoeSizeId + '\'' +
                ", adultSize=" + adultSize +
                ", size=" + size +
                '}';
    }

    public String getShoeSizeId() {
        return shoeSizeId;
    }

    public boolean isAdultSize() {
        return adultSize;
    }

    public int getSize() {
        return size;
    }

    public static class Builder{

        private String shoeSizeId;
        private boolean adultSize;
        private int size;

        public ShoeSize.Builder setSizeId(String shoeSizeId) {
            this.shoeSizeId = shoeSizeId;
            return this;
        }
        public ShoeSize.Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public ShoeSize.Builder isAdultSize(boolean adultSize) {
            this.adultSize = adultSize;
            return this;
        }

        public ShoeSize build(){
            return new ShoeSize(this);
        }

        public ShoeSize.Builder copy(ShoeSize shoeSize){
            this.shoeSizeId = shoeSize.shoeSizeId;
            this.size = shoeSize.size;
            this.adultSize = shoeSize.adultSize;

            return this;

        }

    }

}
