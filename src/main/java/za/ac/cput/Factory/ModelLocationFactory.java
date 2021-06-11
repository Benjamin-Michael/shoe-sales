/*ModelLocationFactory.java
  Factory for ModelLocation class
  Author: Lonwabo Alvin (217213685)
  Date: 09/06/2021
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Model;
import za.ac.cput.Entity.ModelLocation;
import za.ac.cput.Util.GenericHelper;

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
