package ffhs.schwendh.eventmanager.rest.service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ffhs.schwendh.eventmanager.dao.PersonDao;
import ffhs.schwendh.eventmanager.domain.Person;

@Service
public class PersonServiceImpl implements PersonService
{
	private final AtomicLong Person_ID_SEQ = new AtomicLong();
	private final ConcurrentMap<Long, Person> personsMap = new ConcurrentHashMap<Long, Person>();

	@Autowired
	private PersonDao personDao;	

	public Person create(Person person)
	{
		personDao.savePerson(person);
		return person;
	}

	public Person read(int personId)
	{
		Person person = personDao.getPerson(personId);
		return person;
	}

	public Person update(Person person)
	{
		Person updatedPerson = personDao.updatePerson(person);
		return updatedPerson;
	}

	public void delete(Person person)
	{
		personDao.deletePerson(person);
	}

	public Collection<Person> list()
	{
		return personsMap.values();
	}
}
