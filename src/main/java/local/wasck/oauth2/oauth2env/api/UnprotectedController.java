package local.wasck.oauth2.oauth2env.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.wasck.oauth2.oauth2env.api.model.User;
import lombok.Getter;

@RestController
@RequestMapping("unprotected")
public class UnprotectedController {
	
	@Getter
	private List<User> unprotectedUsers;

	public UnprotectedController() {
		this.unprotectedUsers = new ArrayList<User>();
		
		unprotectedUsers.add(new User("user4", "user4@local.com"));
		unprotectedUsers.add(new User("user5", "user5@local.com"));
		unprotectedUsers.add(new User("user6", "user6@local.com"));
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(this.unprotectedUsers, HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUsername(
			@PathVariable("username") String username
	) throws RuntimeException {
		return new ResponseEntity<User>(
				this.unprotectedUsers.stream().filter(user -> user.getUsername().equals(username)).findFirst()
				.orElseThrow(() -> new RuntimeException("No User '" + username + "' found")),
				HttpStatus.OK);
	}
}
