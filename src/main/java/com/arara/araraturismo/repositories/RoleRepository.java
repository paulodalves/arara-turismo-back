package com.arara.araraturismo.repositories;

import java.util.Optional;

import com.arara.araraturismo.models.ERole;
import com.arara.araraturismo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}