/**
 * 
 */
package com.github.springmvc.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author budi
 *
 */
public class HibernateContextListener implements ServletContextListener{
	private static final Logger logger = LoggerFactory.getLogger(HibernateContextListener.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("context initialized, register Hibernate Persistence Provider");
		HibernatePersistenceProviderResolver.register();		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		logger.info("context destroyed");
	}

}
