package com.example.game;

import com.example.game.model.GameStatistics;
import com.example.game.model.GameViewModel;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = GameApplication.class
)
@AutoConfigureMockMvc
public class GameApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GameViewModel gameViewModel;
    @MockBean
    private GameStatistics gameStatistics;

    @Test
    public void openLandingPage() throws Throwable {
        mockMvc.perform(get("/play"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("game", Matchers.is(gameViewModel)))
                .andExpect(model().attribute("statistics", Matchers.is(gameStatistics)));
    }

    @Test
    //@DirtiesContext
    public void playFirstMove() throws Throwable {
        mockMvc.perform(post("/play")
                .param("guess", "50"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("game", Matchers.is(gameViewModel)))
                .andExpect(model().attribute("statistics", Matchers.is(gameStatistics)));
    }
}