package ffhs.schwendh.eventmanager.rest.controller;

import java.util.ArrayList;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ffhs.schwendh.eventmanager.domain.Person;
import ffhs.schwendh.eventmanager.rest.service.PersonService;


@Controller
@RequestMapping(value = "/users")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private PersonService personService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Person create(@RequestBody Person person) {
		LOGGER.info("Creating new user {}", person);

		return personService.create(person);
	}

	@RequestMapping(value = "/{personId}", method = RequestMethod.GET)
	@ResponseBody
	public Person read(@PathVariable(value = "personId") int personId) {
		LOGGER.info("Reading person with id {}", personId);
		Person person = personService.read(personId);

		Validate.isTrue(person != null, "Unable to find user with id: " + personId);

		return person;
	}

//	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
//	@ResponseStatus(value = HttpStatus.NO_CONTENT)
//	public void update(@PathVariable(value = "userId") long userId, @RequestBody User user) {
//		LOGGER.info("Updating user with id {} with {}", userId, user);
//
//		Validate.isTrue(userId == user.getId(), "userId doesn't match URL userId: " + user.getId());
//
//		userService.update(user);
//	}
//
//	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
//	@ResponseStatus(value = HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable(value = "userId") long userId) {
//		LOGGER.info("Deleting user with id {}", userId);
//
//		userService.delete(userId);
//	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	@ResponseBody
//	public UserList list() {
//		LOGGER.info("Listing users");
//
//		return new UserList(new ArrayList<User>(userService.list()));
//	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleClientErrors(Exception ex) {
		LOGGER.error(ex.getMessage(), ex);
		return ex.getMessage();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String handleServerErrors(Exception ex) {
		LOGGER.error(ex.getMessage(), ex);
		return ex.getMessage();
	}
}
