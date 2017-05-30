/**
 * 
 */
package com.github.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.springmvc.model.Menu;

/**
 * @author budi
 *
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {
	List<Menu> findByActiveOrderByPosition(boolean isActive);
	List<Menu> findByActiveAndParentIdOrderByPosition(boolean isActive, String parentId);
	Menu findOneByIdAndActive(String id, boolean active);
}
