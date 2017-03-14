package com.github.springmvc.advice;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.github.springmvc.model.Menu;
import com.github.springmvc.model.Role;
import com.github.springmvc.repository.RoleRepository;

@ControllerAdvice
public class RoleAdvice {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RoleRepository roleRepository;
	
	@ModelAttribute("menuAuthorities")
    public Set<String> populateMenuByRole() {	
		UserDetails user = null;
		Set<String> menuAuthorities = new HashSet<String>();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
		if (principal != null && principal instanceof UserDetails) {
			user = (UserDetails)principal;
			logger.debug("userdetails={}", user);			
			logger.debug("authorities={}", user.getAuthorities());
			for (GrantedAuthority auth : user.getAuthorities()) {				
				Role role = roleRepository.findOneByIdAndActive(auth.getAuthority(), true);				
				if(role != null){
					Set<Menu> menuSet = role.getMenus();
					for (Menu menu : menuSet) {
						if(menu.isActive()){
							menuAuthorities.add(menu.getId());							
						}
					}
				}
			}			
		} else {
			logger.debug("not logged in yet");
		}		
        return menuAuthorities;
    }	
}
