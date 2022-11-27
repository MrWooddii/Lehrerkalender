package com.keeper.lehrerkalender.persistence.daos;

import com.keeper.lehrerkalender.rest.controllers.enums.RoleEnum;
import com.keeper.lehrerkalender.persistence.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findUserRoleByName(RoleEnum name);
}
