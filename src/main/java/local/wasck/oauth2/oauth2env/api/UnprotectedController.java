package local.wasck.oauth2.oauth2env.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.wasck.oauth2.oauth2env.api.model.User;

@RestController
@RequestMapping("protected")
public class UnprotectedController {

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		List<User> unprotectedUsers = new ArrayList<User>();
		
		unprotectedUsers.add(new User("user4", "user4@local.com"));
		unprotectedUsers.add(new User("user5", "user5@local.com"));
		unprotectedUsers.add(new User("user6", "user6@local.com"));
		
		return new ResponseEntity<List<User>>(unprotectedUsers, HttpStatus.OK);
	}
}
