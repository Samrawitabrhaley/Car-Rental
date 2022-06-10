package edu.miu.user_service.controller;

import edu.miu.user_service.domain.Role;
import edu.miu.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping("/")
    public Role saveRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }
}
