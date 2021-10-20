package za.ac.cput.service.impl;

import za.ac.cput.entity.Location;
import za.ac.cput.service.IService;

import java.util.Set;

public interface ILocationService extends IService<Location, String>{

        Set<Location> getAll();

}
