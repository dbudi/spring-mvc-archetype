/**
 * 
 */
package com.github.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.springmvc.model.Role;

/**
 * @author budi
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	List<Role> findByActive(boolean active);
	Role findOneByIdAndActive(String id, boolean active);
}
