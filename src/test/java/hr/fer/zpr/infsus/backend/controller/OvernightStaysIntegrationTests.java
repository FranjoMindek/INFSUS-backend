package hr.fer.zpr.infsus.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.fer.zpr.infsus.backend.BackendApplication;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsertDTO;
import hr.fer.zpr.infsus.backend.feature.overnightstays.OvernightStaysRepository;
import hr.fer.zpr.infsus.backend.feature.overnightstays.OvernightStaysService;
import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayInsertDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = BackendApplication.class)
@AutoConfigureMockMvc
public class OvernightStaysIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private OvernightStaysService overnightStaysService;
    @Autowired
    private OvernightStaysRepository overnightStaysRepository;

    @Test
    public void testInsert_shouldFindInsertedOvernightStay() throws Exception {
        ClientInsertDTO clientInsertDTO = new ClientInsertDTO();
        clientInsertDTO.setClientFirstName("Franjo");
        clientInsertDTO.setClientLastName("Mindek");
        clientInsertDTO.setClientPhoneNumber("123321123321");
        clientInsertDTO.setClientNationalId("696969696969");
        OvernightStayInsertDTO overnightStayInsertDTO = new OvernightStayInsertDTO();
        overnightStayInsertDTO.setRoomId(1L);
        overnightStayInsertDTO.setOvernightStayDateFrom(new Date());
        overnightStayInsertDTO.setOvernightStayDateTo(new Date());
        overnightStayInsertDTO.setClientInsertDTO(clientInsertDTO);

        var response = mockMvc.perform(post("/api/overnight-stays")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(overnightStayInsertDTO)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn()
                .getResponse();

        String location = response.getHeader("Location");
        assertThat(location).isNotNull();
        mockMvc.perform(get(location))
                .andExpect(status().isOk());
    }
}
