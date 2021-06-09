/*  Promotion.java
    Entity for Promotion
    Author: Keenan Barends (219002959)
    Date: 09 June 2021
 */

package za.ac.cput.Entity;

public class Promotion {

    private int promotionId;
    private String description;
    private double discountPercentage;

    private Promotion(Builder builder)
    {
        this.promotionId = builder.promotionId;
        this.description = builder.description;
        this.discountPercentage = builder.discountPercentage;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "promotionId=" + promotionId +
                ", description='" + description + '\'' +
                ", discountPercentage=" + discountPercentage +
                '}';
    }

    public static class Builder{

        private int promotionId;
        private String description;
        private double discountPercentage;

        public Builder setPromotionId(int promotionId)
        {
            this.promotionId = promotionId;
            return this;
        }

        public Builder setDescription(String description)
        {
            this.description = description;
            return this;
        }

        public Builder setDiscountPercentage(double discountPercentage)
        {
            this.discountPercentage = discountPercentage;
            return this;
        }

        public Promotion build()
        {
            return new Promotion(this);
        }

        public Builder copy(Promotion promotion)
        {
            this.promotionId = promotionId;
            this.description = description;
            this.discountPercentage = discountPercentage;
            return this;
        }
    }


}
