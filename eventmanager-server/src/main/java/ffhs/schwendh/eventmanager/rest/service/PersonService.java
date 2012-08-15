package ffhs.schwendh.eventmanager.rest.service;

import java.util.Collection;

import ffhs.schwendh.eventmanager.domain.Person;

public interface PersonService {
	Person create(Person person);

	Person read(int userId);

	Person update(Person person);

	void delete(Person person);

	Collection<Person> list();
}
