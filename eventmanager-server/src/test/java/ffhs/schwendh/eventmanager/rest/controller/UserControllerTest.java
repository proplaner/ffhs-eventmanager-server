package ffhs.schwendh.eventmanager.rest.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import ffhs.schwendh.eventmanager.domain.Person;

@Ignore("Server needs to be running")
public class UserControllerTest
{
	private static final String REST_SERVICE_URL = "http://localhost:8080/eventmanager-server/users";
	private static RestTemplate restTemplate;

	@BeforeClass
	public static void beforeClass()
	{
		restTemplate = new RestTemplate();
	}

	@Test
	public void create()
	{
		createAndAssertPerson();
	}

	@Test
	public void read()
	{
		Person createdPerson = createAndAssertPerson();
		Person person = restTemplate.getForObject(REST_SERVICE_URL
				+ "/{userId}", Person.class, createdPerson.getId());
		assertUser(person, createdPerson);
	}

	//	public void update() {
	//		User user = createAndAssertUser();
	//		user.setName("Updated user name");
	//		restTemplate.put(REST_SERVICE_URL + "/{userId}", user, user.getId());
	//		User updatedUser = restTemplate.getForObject(REST_SERVICE_URL + "/{userId}", User.class, user.getId());
	//		assertUser(updatedUser, user);
	//	}
	//
	//	public void updateIncorrectUrl() {
	//		User user = createAndAssertUser();
	//		user.setName("Updated user name");
	//		try {
	//			restTemplate.put(REST_SERVICE_URL + "/{userId}", user, user.getId() + 1);
	//			fail("Expecting HttpClientErrorException: 400 Bad Request");
	//		} catch (HttpClientErrorException e) {
	//			assertEquals(e.getStatusCode(), HttpStatus.BAD_REQUEST);
	//		}
	//	}
	//
	//	public void delete() {
	//		User createdUser = createAndAssertUser();
	//		restTemplate.delete(REST_SERVICE_URL + "/{userId}", createdUser.getId());
	//		try {
	//			restTemplate.getForObject(REST_SERVICE_URL + "/{userId}", User.class, createdUser.getId());
	//			fail("Expecting HttpClientErrorException: 400 Bad Request");
	//		} catch (HttpClientErrorException e) {
	//			assertEquals(e.getStatusCode(), HttpStatus.BAD_REQUEST);
	//		}
	//	}
	//
	//	public void list() {
	//		UserList initialUsers = restTemplate.getForObject(REST_SERVICE_URL, UserList.class);
	//		User createdUser = createAndAssertUser();
	//		UserList users = restTemplate.getForObject(REST_SERVICE_URL, UserList.class);
	//		List<User> createdUsers = new ArrayList<User>(users.getUsers());
	//		createdUsers.removeAll(initialUsers.getUsers());
	//		assertEquals(createdUsers.size(), 1);
	//		assertUser(createdUsers.get(0), createdUser);
	//	}

	private Person createAndAssertPerson()
	{
		Person person = new Person();
		person.setId(0);
		person.setFirstName("Firstname");
		person.setLastName("Lastname");
		return createAndAssertPerson(person);
	}

	private Person createAndAssertPerson(Person person)
	{
		Person createdUser = restTemplate.postForObject(REST_SERVICE_URL,
				person, Person.class);
		assertUserNoId(createdUser, person);
		return createdUser;
	}

	private void assertUserNoId(Person actual, Person expected)
	{
		assertTrue(actual.getId() > 0);
		assertEquals(actual.getFirstName(), expected.getFirstName());
		assertEquals(actual.getLastName(), expected.getLastName());
	}

	private void assertUser(Person actual, Person expected)
	{
		assertTrue(actual.getId() > 0);
		assertEquals(actual.getLastName(), expected.getLastName());
		//		assertEquals(actual.getRegistrationDate(), expected.getRegistrationDate());
	}
}
