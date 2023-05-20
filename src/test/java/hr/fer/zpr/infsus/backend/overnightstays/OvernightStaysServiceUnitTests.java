package hr.fer.zpr.infsus.backend.overnightstays;

import hr.fer.zpr.infsus.backend.feature.clients.ClientsService;
import hr.fer.zpr.infsus.backend.feature.overnightstays.OvernightStaysMapper;
import hr.fer.zpr.infsus.backend.feature.overnightstays.OvernightStaysRepository;
import hr.fer.zpr.infsus.backend.feature.overnightstays.OvernightStaysService;
import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayDTO;
import hr.fer.zpr.infsus.backend.feature.overnightstays.model.OvernightStay;
import hr.fer.zpr.infsus.backend.feature.rooms.RoomsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OvernightStaysServiceUnitTests {
    @InjectMocks
    private OvernightStaysService overnightStaysService;
    @Mock
    private OvernightStaysRepository overnightStaysRepository;
    @Mock
    private ClientsService clientsService;
    @Mock
    private RoomsService roomsService;

    @Test
    public void testGetShouldReturnOvernightStays() {
        OvernightStay overnightStay1 = OvernightStay.builder()
                .overnightStayId(1L)
                .overnightStayStatusId("TEST_STATUS")
                .overnightStayDateFrom(new Date())
                .overnightStayDateTo(new Date())
                .clientId(1L)
                .roomId(1L)
                .build();

        OvernightStay overnightStay2 = OvernightStay.builder()
                .overnightStayId(2L)
                .overnightStayStatusId("TEST_STATUS")
                .overnightStayDateFrom(new Date())
                .overnightStayDateTo(new Date())
                .clientId(1L)
                .roomId(1L)
                .build();

        List<OvernightStay> overnightStayList = List.of(overnightStay1, overnightStay2);

        when(overnightStaysRepository.getOvernightStays()).thenReturn(overnightStayList);

        List<OvernightStayDTO> result = overnightStaysService.getOvernightStays();

        assertThat(result).hasSize(2);
    }

    @Test
    public void testGetByShouldReturnOvernightStay() {
        OvernightStay overnightStay1 = OvernightStay.builder()
                .overnightStayId(1L)
                .overnightStayStatusId("TEST_STATUS")
                .overnightStayDateFrom(new Date())
                .overnightStayDateTo(new Date())
                .clientId(1L)
                .roomId(1L)
                .build();

        when(overnightStaysRepository.getOvernightStayById(anyLong())).thenReturn(overnightStay1);

        OvernightStayDTO result = overnightStaysService.getOvernightStayById(1L);

        assertThat(result).usingRecursiveComparison().isEqualTo(OvernightStaysMapper.toDTO(overnightStay1));
    }
}
