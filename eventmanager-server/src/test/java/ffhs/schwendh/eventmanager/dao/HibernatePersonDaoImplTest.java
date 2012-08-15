/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ffhs.schwendh.eventmanager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ffhs.schwendh.eventmanager.domain.Person;

/**
 * 
 * @author Administrator
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
//@Transactional
public class HibernatePersonDaoImplTest
{
	@Autowired
	private PersonDao personDao;

	/**
	 * testListAllPersons
	 */
	@Test
	public void testListAllPersons()
	{
		Person person = new Person();
		person.setFirstName("Firstname");
		person.setLastName("Lastname");
		person.setMoney(100.00);

		personDao.savePerson(person);
	}
}
