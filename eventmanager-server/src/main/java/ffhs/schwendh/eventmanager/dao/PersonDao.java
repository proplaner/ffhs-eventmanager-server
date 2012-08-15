/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ffhs.schwendh.eventmanager.dao;

import ffhs.schwendh.eventmanager.domain.Person;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * 
 * @author Administrator
 */
public interface PersonDao
{

	/**
	 * Reads all persons from the database
	 * 
	 * @return the Person objects.
	 */
	List<Person> listAllPersons();

	/**
	 * Reads a person from the database with the given id
	 * 
	 * @param personId
	 *            the primary key of the person to be read from the database.
	 * @return the Person object to the corresponding id.
	 */
	Person getPerson(Integer personId);

	/**
	 * Saves the current person to the database
	 * 
	 * @param person
	 *            the Person object to be saved to the database.
	 * @return the primary key of the saved Person object.
	 */
	Integer savePerson(Person person);

	/**
	 * Reads a person from the database with the given username
	 * 
	 * @param username
	 *            the username of the person to be read from the database.
	 * @return the Person object to the corresponding username.
	 */
	Person selectPersonByEmail(String email);

	/**
	 * Updates the current person in the database.
	 * 
	 * @param person
	 *            the Person object to be updated in the database.
	 */
	Person updatePerson(Person person);

	/**
	 * Deletes current person from the database.
	 * 
	 * @param person
	 *            the Person object to be deleted.
	 * @throws DataAccessException
	 */
	void deletePerson(Person person) throws DataAccessException;
}
