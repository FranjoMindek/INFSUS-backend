package hr.fer.zpr.infsus.backend.overnightstays;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.fer.zpr.infsus.backend.BackendApplication;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsertDTO;
import hr.fer.zpr.infsus.backend.feature.overnightstays.OvernightStaysService;
import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayDTO;
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
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    @Test
    public void testShouldFindAndThenDeleteInsertedOvernightStay() throws Exception {
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
                .andReturn()
                .getResponse();

        String location = response.getHeader("Location");
        assertThat(location).isNotNull();

        mockMvc.perform(get(location))
                .andExpect(status().isOk());

        mockMvc.perform(delete(location))
                .andExpect(status().isNoContent());

        mockMvc.perform(get(location))
                .andExpect(status().isNotFound());

    }

    @Test
    public void testShouldUpdateInsertedOvernightStay() throws Exception {
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

        var postRespose = mockMvc.perform(post("/api/overnight-stays")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(overnightStayInsertDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse();

        String location = postRespose.getHeader("Location");
        assertThat(location).isNotNull();

        var getResponse = mockMvc.perform(get(location))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        OvernightStayDTO updateDTO = objectMapper.readValue(getResponse.getContentAsString(), OvernightStayDTO.class);
        updateDTO.setRoomId(2L);
        updateDTO.setOvernightStayStatusId("OVERNIGHT_STAY_STATUS.FINISHED");
        mockMvc.perform(put(location)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(updateDTO)))
                .andExpect(status().isOk());

        mockMvc.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roomId", is(2)))
                .andExpect(jsonPath("$.overnightStayStatusId", is("OVERNIGHT_STAY_STATUS.FINISHED")));
    }
}
