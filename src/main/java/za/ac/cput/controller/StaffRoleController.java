package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Staff;
import za.ac.cput.entity.StaffRole;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.factory.StaffRoleFactory;
import za.ac.cput.service.impl.StaffRoleService;
import za.ac.cput.service.impl.StaffService;

import java.util.Set;
@RestController
@RequestMapping("/staffRole")
public class StaffRoleController {
    @Autowired
    private StaffRoleService staffRoleService;

    @PostMapping("/create")
    public StaffRole create(@RequestBody StaffRole staffRole){
        StaffRole newRole = StaffRoleFactory.createStaffRole(staffRole.getRoleId(), staffRole.getRoleDescription());
        return staffRoleService.create(newRole);
    }
    @PostMapping("/update")
    public StaffRole update(@RequestBody StaffRole staffRole) { return staffRoleService.update(staffRole); }

    @GetMapping("/all")
    public Set<StaffRole> getAll(){
        return staffRoleService.getAll();
    }


    @DeleteMapping("/delete/{roleId}")
    public boolean delete(@PathVariable String roleId) { return staffRoleService.delete(roleId); }

}


