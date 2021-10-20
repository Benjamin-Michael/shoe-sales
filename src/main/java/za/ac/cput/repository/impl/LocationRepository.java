package za.ac.cput.repository.impl;
//AUTHOR: Lonwabo Alvin 217213685

import za.ac.cput.entity.Location;
//AUTHOR: Lonwabo Alvin 217213685

import java.util.HashSet;
import java.util.Set;

public class LocationRepository implements ILocationRepository {

    private Set<Location> LocationDb =null;
    private static LocationRepository repository = null;

    public LocationRepository(){
        LocationDb = new HashSet<Location>();
    }
    public static LocationRepository getRepository(){
        if(repository == null)
            repository = new LocationRepository();
        return repository;
    }
    @Override
    public Location create( Location location){
        this.LocationDb.add(location);
        return location;
    }
    @Override
    public Location read(String storeLocationId){
        Location location = null;

        for(Location l : this.LocationDb){
            if(l.getStoreLocationId().equalsIgnoreCase(storeLocationId)){
                location = l;
                break;
            }
        }
        return location;
    }
    @Override
    public Location update(Location location){
        Location l = read(location.getStoreLocationId());
        if(l != null){
            this.LocationDb.remove(l);
            this.LocationDb.add(location);
        }
        return location;
    }
    @Override
    public boolean delete(String storeLocationId){
        Location location = read(storeLocationId);
        if(location != null)
            this.LocationDb.remove(location);
            return true;
    }
    @Override
    public Set<Location> getAll(){
        return LocationDb;
    }
}
