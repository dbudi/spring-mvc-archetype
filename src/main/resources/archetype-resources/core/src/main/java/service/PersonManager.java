#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.service;

import ${package}.model.Person;

import java.util.List;

/**
 * @author budi
 *
 */
public interface PersonManager extends GenericManager<Person, Long>{
	List<Person> findByLastName(String lastName);
}
