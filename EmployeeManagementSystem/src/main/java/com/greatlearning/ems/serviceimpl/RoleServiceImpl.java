package com.greatlearning.ems.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.ems.entity.Roles;
import com.greatlearning.ems.repository.RoleRepository;
import com.greatlearning.ems.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	@Transactional
	public List<Roles> findAll() {
		List<Roles> roles = roleRepository.findAll();
		return roles;
	}

	@Override
	@Transactional
	public Optional<Roles> findById(int theId) {
		return roleRepository.findById(theId);
	}

	@Override
	@Transactional
	public void save(Roles theRole) {
		roleRepository.save(theRole);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		roleRepository.deleteById(theId);
	}

	@Override
	public Optional<Roles> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// @Transactional
	// public Optional<Roles> findByName(String name) {
	// return Optional.ofNullable(roleRepository.getRoleByName(name));
	// }

}
