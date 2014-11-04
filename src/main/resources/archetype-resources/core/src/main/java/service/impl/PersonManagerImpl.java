#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.service.impl;

import ${package}.dao.PersonDao;
import ${package}.model.Person;
import ${package}.service.PersonManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author budi
 *
 */
@Service("personManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Long> implements PersonManager{
	
	PersonDao personDao;
	
	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.dao = personDao;
		this.personDao = personDao;
	}


	@Override
	public List<Person> findByLastName(String lastName) {
		return personDao.findByLastName(lastName);
	}

}
