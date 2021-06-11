/*ModelFactory.java
  Factory for Model class
  Author: Lonwabo Alvin (217213685)
  Date: 09/06/2021
 */

package za.ac.cput.Factory;


import za.ac.cput.Entity.Model;
import za.ac.cput.Util.GenericHelper;

public class ModelFactory {


    public static Model createModel( String modelName, String modelDescription){
        String modelId = GenericHelper.generateId();
        Model model = new Model.Builder().setModelId(modelId)
                      .setModelName(modelName)
                      .setModelDescription(modelDescription)
                      .build();

        return model;
    }
}
