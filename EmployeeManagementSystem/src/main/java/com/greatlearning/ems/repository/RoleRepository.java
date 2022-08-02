package com.greatlearning.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.ems.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
