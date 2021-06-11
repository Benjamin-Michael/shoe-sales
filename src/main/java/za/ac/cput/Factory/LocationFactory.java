/*LocationFactory.java
  Factory for Location class
  Author: Lonwabo Alvin (217213685)
  Date: 09/06/2021
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Location;
import za.ac.cput.Util.GenericHelper;

public class LocationFactory {
    public static Location createLocation(String address) {
        String storeLocationId = GenericHelper.generateId();
         Location location = new Location.builder().setStoreLocationId(storeLocationId).setAddress(address).build();


         return location;
    }
}
