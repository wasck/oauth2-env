package local.wasck.oauth2.oauth2env;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import local.wasck.oauth2.oauth2env.api.model.User;

@RunWith(SpringRunner.class)
public class AbstractTest {

	@Autowired
	private MockMvc mockMvc;
	
	protected String performGetRequest(String url) throws UnsupportedEncodingException, Exception {
		return this.mockMvc.perform(
				MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)
		).andReturn().getResponse().getContentAsString();
		
	}
}
