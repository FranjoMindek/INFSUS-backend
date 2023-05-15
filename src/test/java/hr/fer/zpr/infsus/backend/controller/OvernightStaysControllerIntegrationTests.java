package hr.fer.zpr.infsus.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.fer.zpr.infsus.backend.features.overnightstays.OvernightStaysController;
import hr.fer.zpr.infsus.backend.features.overnightstays.OvernightStaysService;
import hr.fer.zpr.infsus.backend.features.overnightstays.data.OvernightStay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OvernightStaysController.class)
public class OvernightStaysControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private OvernightStaysService overnightStaysService;

    @Test
    public void testInsertShouldReturn400BadRequest() throws Exception {
        OvernightStay overnightStay = OvernightStay.builder().build();

        String requestBody = objectMapper.writeValueAsString(overnightStay);
        mockMvc.perform(post("/api/overnight-stays")
                        .contentType("application/json")
                        .content(requestBody))
                        .andExpect(status().isBadRequest());
    }

}
