/*ModelLocationFactory.java
  Factory for ModelLocation class
  Author: Lonwabo Alvin (217213685)
  Date: 09/06/2021
 */
package za.ac.cput.factory;

import za.ac.cput.entity.ModelLocation;
import za.ac.cput.util.GenericHelper;

public class ModelLocationFactory {
    public static ModelLocation createModelLocation(String ModelId, String quantity) {
        String locationId = GenericHelper.generateId();
        ModelLocation modelLocation = new ModelLocation.Builder().setLocationId(locationId)
                .setModelId(ModelId)
                .setQuantity(quantity)
                .build();

        return modelLocation;
    }
}
