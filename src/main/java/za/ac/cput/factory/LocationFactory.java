/*LocationFactory.java
  Factory for Location class
  Author: Lonwabo Alvin (217213685)
  Date: 09/06/2021
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Location;
import za.ac.cput.util.GenericHelper;

public class LocationFactory {
    public static Location createLocation(String address) {
        String storeLocationId = GenericHelper.generateId();
         Location location = new Location.Builder()
                 .setStoreLocationId(storeLocationId)
                 .setAddress(address).build();


         return location;
    }
}
