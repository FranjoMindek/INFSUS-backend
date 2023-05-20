package hr.fer.zpr.infsus.backend.overnightstays;

import hr.fer.zpr.infsus.backend.feature.overnightstays.OvernightStaysRepository;
import hr.fer.zpr.infsus.backend.feature.overnightstays.model.OvernightStay;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OvernightStaysRepositoryUnitTests {

    @Autowired
    private OvernightStaysRepository overnightStaysRepository;

    @Test
    public void testShouldFindInsertedOvernightStayById() {
        OvernightStay overnightStay1 = OvernightStay.builder()
                .overnightStayDateFrom(new Date())
                .overnightStayDateTo(new Date())
                .clientId(1L)
                .roomId(1L)
                .build();

        Long id = overnightStaysRepository.insertOvernightStay(overnightStay1);
        OvernightStay result = overnightStaysRepository.getOvernightStayById(id);

        assertThat(result).isNotNull();
        assertThat(result.getOvernightStayId()).isEqualTo(id);
    }

    @Test
    public void testShouldDeleteInsertedOvernightStay() {
        OvernightStay overnightStay1 = OvernightStay.builder()
                .overnightStayDateFrom(new Date())
                .overnightStayDateTo(new Date())
                .clientId(1L)
                .roomId(1L)
                .build();

        Long id = overnightStaysRepository.insertOvernightStay(overnightStay1);
        boolean result = overnightStaysRepository.deleteOvernightStay(id);

        assertThat(result).isTrue();
    }

    @Test
    public void shouldUpdateInsertedOvernightStay() {
        OvernightStay overnightStay1 = OvernightStay.builder()
                .overnightStayDateFrom(new Date())
                .overnightStayDateTo(new Date())
                .clientId(1L)
                .roomId(1L)
                .build();

        Long id = overnightStaysRepository.insertOvernightStay(overnightStay1);

        overnightStay1.setOvernightStayId(id);
        overnightStay1.setOvernightStayStatusId("OVERNIGHT_STAY_STATUS.FINISHED");
        boolean updated = overnightStaysRepository.updateOvernightStay(overnightStay1);
        assertThat(updated).isTrue();

        OvernightStay result = overnightStaysRepository.getOvernightStayById(id);
        assertThat(result.getOvernightStayStatusId()).isEqualTo("OVERNIGHT_STAY_STATUS.FINISHED");
    }

    @Test
    public void shouldReturnAllOvernightStays() {
        OvernightStay overnightStay1 = OvernightStay.builder()
                .overnightStayDateFrom(new Date())
                .overnightStayDateTo(new Date())
                .clientId(1L)
                .roomId(1L)
                .build();

        OvernightStay overnightStay2 = OvernightStay.builder()
                .overnightStayDateFrom(new Date())
                .overnightStayDateTo(new Date())
                .clientId(2L)
                .roomId(2L)
                .build();

        overnightStaysRepository.insertOvernightStay(overnightStay1);
        overnightStaysRepository.insertOvernightStay(overnightStay2);

        List<OvernightStay> result = overnightStaysRepository.getOvernightStays();

        assertThat(result).hasSizeGreaterThan(2);
    }
}
