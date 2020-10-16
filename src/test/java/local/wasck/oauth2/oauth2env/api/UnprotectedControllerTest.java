package local.wasck.oauth2.oauth2env.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import local.wasck.oauth2.oauth2env.AbstractTest;


@WebMvcTest(UnprotectedController.class)
class UnprotectedControllerTest extends AbstractTest{
	
	private final String unprotectedUrl = "/unprotected";
	
	@Test
	public void unprotectedController() throws Exception {
		
		JSONArray jsonArray = new JSONArray(super.performGetRequest(this.unprotectedUrl));
		assertNotNull(jsonArray);
		assertEquals(new UnprotectedController().getUnprotectedUsers().size(), jsonArray.length());
	}

}
