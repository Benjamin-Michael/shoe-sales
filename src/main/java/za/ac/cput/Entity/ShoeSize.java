/*  ShoeSize.java
    Entity for the ShoeSize
    Author: Michael Benjamin (219071438)
    Date: 09 June 2021
 */

package za.ac.cput.Entity;

public class ShoeSize {

    private int size;

    private ShoeSize(ShoeSize.Builder builder){
        this.size = builder.size;

    }

    @Override
    public String toString() {
        return "ShoeSize{" +
                "size=" + size +
                '}';
    }

    public static class Builder{

        private int size;

        public ShoeSize.Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public ShoeSize build(){
            return new ShoeSize(this);
        }

        public ShoeSize.Builder copy(ShoeSize shoeSize){
            this.size = shoeSize.size;

            return this;

        }

    }

}
