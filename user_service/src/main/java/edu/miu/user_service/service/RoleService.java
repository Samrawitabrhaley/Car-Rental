package edu.miu.user_service.service;

import edu.miu.user_service.domain.Role;
import edu.miu.user_service.domain.RoleType;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(RoleType name);

    Role saveRole(Role role);
}
