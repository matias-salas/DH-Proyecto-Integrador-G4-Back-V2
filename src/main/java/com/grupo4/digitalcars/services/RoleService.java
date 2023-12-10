package com.grupo4.digitalcars.services;

import com.grupo4.digitalcars.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRoles();
    Optional<Role> getRoleById(Integer id);
    Role saveRole(Role role);
    Role updateRole(Role role);
    void deleteRoleById(Integer id);
}
