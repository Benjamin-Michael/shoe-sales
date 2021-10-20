
package za.ac.cput.repository.impl;
/*ILocationRepo.java
  Interface for Location Repo
  Author: Lonwabo Alvin (217213685)
  Date: 09/06/2021
 */
        import za.ac.cput.entity.Location;
        import za.ac.cput.repository.IRepository;

        import java.util.Set;

public interface ILocationRepository extends IRepository<Location, String> {
    public Set<Location> getAll();
}
