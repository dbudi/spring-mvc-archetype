#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.dao;

import ${package}.model.Person;

import java.util.List;

/**
 * @author budi
 *
 */
public interface PersonDao extends GenericDao<Person, Long>{
	public List<Person> findByLastName(String lastName);
}
