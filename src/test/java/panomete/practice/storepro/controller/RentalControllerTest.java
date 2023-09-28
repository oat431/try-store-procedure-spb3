package panomete.practice.storepro.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import panomete.practice.storepro.dto.RateType;
import panomete.practice.storepro.dto.RentalDto;
import panomete.practice.storepro.service.RentalService;


import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
public class RentalControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RentalService rentalService;

    @Test
    public void testGetTop10RentalsByRate() throws Exception {
        RentalDto rentalDto = new RentalDto("title", "description", 2021, 4.99);
        given(rentalService.getTop10Rentals(RateType.G)).willReturn(newArrayList(rentalDto));
        mockMvc.perform(MockMvcRequestBuilders.get("/top10?rate=G"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}