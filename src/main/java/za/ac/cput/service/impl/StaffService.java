package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Shoe;
import za.ac.cput.entity.Staff;
import za.ac.cput.repository.StaffRepository;
import za.ac.cput.repository.impl.ShoeRepository;
import za.ac.cput.repository.impl.StaffRepositoryImp;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class StaffService implements IStaffService{

    private static StaffService staffService = null;
    @Autowired
    private StaffRepository staffRepositoryImpl ;


    @Override
    public Staff create(Staff staff) {
        return this.staffRepositoryImpl.save(staff);
    }

    @Override
    public Staff read(String staffId) {
        return this.staffRepositoryImpl.findById(staffId).orElse(null);
    }

    @Override
    public Staff update(Staff staff) {
        if(this.staffRepositoryImpl.existsById(staff.getStaffId()))
        return this.staffRepositoryImpl.save(staff);
        return null;
    }

    @Override
    public boolean delete(String staffId) { this.staffRepositoryImpl.deleteById(staffId);

        if(this.staffRepositoryImpl.existsById(staffId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Staff> getAll() {
        return this.staffRepositoryImpl.findAll().stream().collect(Collectors.toSet());
    }
}
