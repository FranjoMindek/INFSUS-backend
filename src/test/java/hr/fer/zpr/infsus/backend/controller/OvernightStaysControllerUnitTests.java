package hr.fer.zpr.infsus.backend.controller;

import hr.fer.zpr.infsus.backend.feature.overnightstays.OvernightStaysController;
import hr.fer.zpr.infsus.backend.feature.overnightstays.OvernightStaysService;
import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OvernightStaysController.class)
public class OvernightStaysControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
    @MockBean
    private OvernightStaysService overnightStaysService;
    private final String API = "/api/overnight-stays";


    @Test
    public void testGet_shouldReturn200Ok() throws Exception {

        OvernightStayDTO overnightStayDTO1 = new OvernightStayDTO();
        overnightStayDTO1.setOvernightStayId(1L);

        OvernightStayDTO overnightStayDTO2 = new OvernightStayDTO();
        overnightStayDTO2.setOvernightStayId(2L);

        List<OvernightStayDTO> overnightStayDTOList = List.of(overnightStayDTO1, overnightStayDTO2);

        Mockito.when(overnightStaysService.getOvernightStays()).thenReturn(overnightStayDTOList);

        mockMvc.perform(get(API))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].overnightStayId", is(1)))
                .andExpect(jsonPath("$[1].overnightStayId", is(2)));
//                .andDo(print());
    }

    @Test
    public void testGetById_shouldReturn404NotFound() throws Exception {
        final long overnightStayId = 999L;
        final String URI = API + "/" + overnightStayId;

        mockMvc.perform(get(URI))
                .andExpect(status().isNotFound());
//                .andDo(print());
    }

    @Test
    public void testGetById_shouldReturn200Ok() throws Exception {
        final long overnightStayId = 999L;
        final String URI = API + "/" + overnightStayId;

        OvernightStayDTO overnightStayDTO = new OvernightStayDTO();
        overnightStayDTO.setOvernightStayId(overnightStayId);

        Mockito.when(overnightStaysService.getOvernightStayById(overnightStayId)).thenReturn(overnightStayDTO);
        mockMvc.perform(get(URI))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.overnightStayId", is(999)));
//                .andDo(print());
    }
}
