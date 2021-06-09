package za.ac.cput.Entity;

public class Location {
    private String storeLocationId, address;

    private Location(Builder builder){
        this.storeLocationId = builder.storeLocationId;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "storeLocationId='" + storeLocationId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private static class Builder{
        private String storeLocationId, address;
        public Builder setStoreLocationId(String storeLocationId) {
            this.storeLocationId = storeLocationId;

            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;

            return this;
        }
        public Location build() {

            return new Location(this);
        }
        public Location.Builder copy(Location location) {
            this.storeLocationId = location.storeLocationId;
            this.address = location.address;
            return this;
        }
    }

}
