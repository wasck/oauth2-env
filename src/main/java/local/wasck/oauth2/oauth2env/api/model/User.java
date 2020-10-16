package local.wasck.oauth2.oauth2env.api.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private UUID id;
	private String username;
	private String email;
	
	public User(String username, String email) {
		this.id = UUID.randomUUID();
		this.username = username;
		this.email = email;
	}
	
}
