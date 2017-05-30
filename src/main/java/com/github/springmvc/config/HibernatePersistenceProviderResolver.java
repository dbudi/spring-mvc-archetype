/**
 * 
 */
package com.github.springmvc.config;

import java.util.Collections;
import java.util.List;

import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceProviderResolver;
import javax.persistence.spi.PersistenceProviderResolverHolder;

import org.hibernate.jpa.HibernatePersistenceProvider;

/**
 * @author budi
 *
 */
public class HibernatePersistenceProviderResolver implements PersistenceProviderResolver{

	private volatile PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
	
	public List<PersistenceProvider> getPersistenceProviders() {
		return Collections.singletonList(persistenceProvider);
	}
	
	public void clearCachedProviders() {
		persistenceProvider = new HibernatePersistenceProvider();
	}
	
	public static void register() {
		PersistenceProviderResolverHolder
		.setPersistenceProviderResolver(new HibernatePersistenceProviderResolver());
	}
}
