package com.devops.lab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.CoreMatchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class LabAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnOurText() throws Exception {

		this.mockMvc
				.perform(get("/greeting").param("name", "Ozzetti" )) // perform a request that can be chained
				.andDo(print()) // we log the result
				.andExpect(content().string(containsString("Hello, Ozzetti!"))); // we check that the Body of the answer contains our expectation
	}
}
