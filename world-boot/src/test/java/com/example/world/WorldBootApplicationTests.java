package com.example.world;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = WorldBootApplication.class)
@AutoConfigureMockMvc
class WorldBootApplicationTests {
    @Autowired private MockMvc mockMvc;

	@Test
	void contextLoads() throws Throwable {
        mockMvc.perform(get("/world/countries/list")).andDo(print()).andExpect(status().isOk());

	}

}
