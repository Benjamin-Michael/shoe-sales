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

    @GetMapping("")
    public Set<Staff> getAllStaff(){
        return staffService.getAll();
    }

    @GetMapping("/{id}")
    public Staff getStaff(@PathVariable String id){
        return staffService.read(id);
    }

    @PostMapping("/create")
    public Staff createStaff(@RequestBody Staff staff){
        Staff newStaff = StaffFactory.createStaff( staff.getFirstName(), staff.getLastName());
        return staffService.create(newStaff);
    }

    @PostMapping("/update")
    public Staff updateStaff(@RequestBody Staff staff){
        return staffService.update(staff);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStaff(@PathVariable String id){
        return staffService.delete(id);
    }

}

