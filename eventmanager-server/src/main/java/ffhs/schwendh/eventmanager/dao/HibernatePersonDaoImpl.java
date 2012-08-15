/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ffhs.schwendh.eventmanager.dao;

import ffhs.schwendh.eventmanager.domain.Person;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Administrator
 */
@Repository
public class HibernatePersonDaoImpl extends HibernateDaoSupport implements
		PersonDao
{
	/**
	 * Inject SessionFactory
	 * 
	 * @param factory
	 */
	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	public List<Person> listAllPersons()
	{
		List<Person> list = getHibernateTemplate().find("from Person");
		return list;
	}

	public Person getPerson(Integer personId)
	{
		return (Person) getHibernateTemplate().get(Person.class, personId);
	}

	public Integer savePerson(Person person)
	{
		Integer ret = (Integer) getHibernateTemplate().save(person);
		return ret;
	}

	public Person selectPersonByEmail(String email)
	{
		List<Person> list = getHibernateTemplate().find(
				"from Person where email = ?", email);
		if (list.size() == 0)
		{
			return null;
		} else if (list.size() == 1)
		{
			Person person = list.get(0);
			return person;
		} else
		{
			throw new DataIntegrityViolationException(
					"More than one Person with this username.");
		}
	}

	public Person updatePerson(Person person)
	{
		getHibernateTemplate().update(person);
		return person;
	}

	public void deletePerson(Person person) throws DataAccessException
	{
		getHibernateTemplate().delete(person);
		// flush hibernate session, so that an error is being thrown here.
		getHibernateTemplate().flush();
	}
}
