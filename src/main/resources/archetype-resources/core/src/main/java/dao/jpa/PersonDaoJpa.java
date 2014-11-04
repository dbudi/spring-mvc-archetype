#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.dao.jpa;

import ${package}.dao.PersonDao;
import ${package}.model.Person;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * @author budi
 *
 */
@Repository("personDao")
public class PersonDaoJpa extends GenericDaoJpa<Person, Long> implements PersonDao{
	public PersonDaoJpa() {
        super(Person.class);
    }
	@Override
	public List<Person> findByLastName(String lastName) {
		Query q = getEntityManager().createQuery("select p from Person p where p.lastName=?");
        q.setParameter(1, lastName);
        return q.getResultList();
	}

}
