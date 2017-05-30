/**
 * 
 */
package com.github.springmvc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.springmvc.exception.ConcurrentLoginException;
import com.github.springmvc.repository.ActiveSessionRepository;
import com.github.springmvc.service.AccountService;

/**
 * @author budi
 *
 */
@Component("customAuthenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {
	private static Logger logger = LoggerFactory.getLogger(LimitLoginAuthenticationProvider.class);
	@Autowired
	private AccountService accountService;	
	@Autowired
	private ActiveSessionRepository sessionRepo;
	@Autowired
	@Qualifier("accountService")
	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		super.setUserDetailsService(userDetailsService);
	}
	
	@Override
	public void setPasswordEncoder(java.lang.Object passwordEncoder){
		super.setPasswordEncoder(new BCryptPasswordEncoder());
	}
	
	
	public Authentication authenticate(Authentication authentication)
	          throws AuthenticationException {
		try {

			Authentication auth = super.authenticate(authentication);
			// user already login
			if(sessionRepo.existsUserName(authentication.getName()).get() > 0){
				logger.error("user already login {}", authentication.getName());
				throw new ConcurrentLoginException( authentication.getName() +" already login");
			}

			//if reach here, means login success, else an exception will be thrown
			//reset the user_attempts
			accountService.resetLoginFailCounter(authentication.getName());

			return auth;

		} catch (BadCredentialsException e) {
			logger.error("user/password wrong", e);
			//invalid login, update to user_attempts
			accountService.increaseLoginFailCounter(authentication.getName());
			throw e;

		} catch (LockedException e){
			//this user is locked!
			logger.error("user "+authentication.getName()+" is locked", e);
			throw e;
		}
	}
}
