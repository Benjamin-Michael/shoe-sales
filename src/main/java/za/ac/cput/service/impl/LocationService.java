package za.ac.cput.service.impl;
//AUTHOR: Lonwabo Alvin 217213685
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Location;
import za.ac.cput.repository.impl.LocationRepository;


import java.util.Set;

@Service
public class LocationService implements ILocationService {

    public static LocationService locationService = null;
    private LocationRepository locationRepository = null;

    private LocationService(){
        this.locationRepository = LocationRepository.getRepository();
    }
    public static LocationService getService(){
        if(locationService == null)
            locationService = new LocationService();
        return locationService;
    }
    @Override
    public Location create(Location location){
        return this.locationRepository.create(location);
    }
    @Override
    public Location read(String storeLocationId){
        return this.locationRepository.read(storeLocationId);
    }
    @Override
    public Location update(Location location){
        return this.locationRepository.update(location);
    }
    @Override
    public boolean delete(String storeLocationId){
        return this.locationRepository.delete(storeLocationId);
    }
    @Override
    public Set<Location> getAll(){
        return this.locationRepository.getAll();
    }

}

