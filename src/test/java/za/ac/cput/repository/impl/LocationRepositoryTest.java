package za.ac.cput.repository.impl;
//AUTHOR: Lonwabo Alvin 217213685
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

class LocationRepositoryTest {
   private static LocationRepository locationRepository;
   private Location location;


   @BeforeEach
    void setUp(){
       locationRepository = new LocationRepository();
       location = LocationFactory.createLocation("23049 Absess street");
   }
   @Test
    void create(){
       Location created = locationRepository.create(location);
       assertEquals(created.getStoreLocationId(), location.getStoreLocationId());
       System.out.println("Created: " + created.getStoreLocationId() + " = Location: " + location.getAddress());
   }
   @Test
    void read(){
       Location read = locationRepository.read(location.getAddress());
       System.out.println("Location read: " + read);
   }
   @Test
    void update(){
       Location updated = new Location.Builder().copy(location).setStoreLocationId("2300").build();
       locationRepository.update(updated);
       System.out.println("Updated ( " + updated.getStoreLocationId() + "): " + updated.getStoreLocationId()
               + " = Location: (" + location.getAddress() + "): " + location.getAddress());
   }
   @Test
    void delete(){
       locationRepository.delete(location.getStoreLocationId());
       System.out.println("Deleted: " + location.getStoreLocationId());
   }
}