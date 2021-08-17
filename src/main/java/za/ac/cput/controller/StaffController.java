package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.service.impl.StaffService;

import java.util.Set;
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/create")
    public Staff create(@RequestBody Staff staff){
        Staff newStaff = StaffFactory.createStaff(staff.getStaffId(), staff.getFirstName(), staff.getLastName());
        return staffService.create(newStaff);
    }
    @PostMapping("/update")
    public Staff update(@RequestBody Staff staff) { return staffService.update(staff); }

    @GetMapping("/all")
    public Set<Staff> getAll(){
        return staffService.getAll();
    }


    @DeleteMapping("/delete/{staffId}")
    public boolean delete(@PathVariable String staffId) { return staffService.delete(staffId); }

}



