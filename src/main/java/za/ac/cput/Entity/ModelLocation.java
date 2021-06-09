package za.ac.cput.Entity;

public class ModelLocation {
    private String modelId, locationId, quantity;

    private ModelLocation(Builder builder){
        this.modelId = builder.modelId;
        this.locationId = builder.locationId;
        this.quantity = builder.quantity;
    }

    @Override
    public String toString() {
        return "ModelLocation{" +
                "modelId='" + modelId + '\'' +
                ", locationId='" + locationId + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    public static class Builder {
        private String modelId, locationId, quantity;

        public ModelLocation.Builder setModelId(String modelId) {
            this.modelId = modelId;

            return this;
        }

        public ModelLocation.Builder setLocationId(String locationId) {
            this.locationId = locationId;

            return this;
        }

        public ModelLocation.Builder setQuantity(String quantity) {
            this.quantity = quantity;

            return this;
        }

        public ModelLocation build() {

            return new ModelLocation(this);
        }

        public ModelLocation.Builder copy(ModelLocation modelLocation) {
            this.modelId = modelLocation.modelId;
            this.locationId = modelLocation.locationId;
            this.quantity = modelLocation.quantity;
            return this;
        }
    }
}