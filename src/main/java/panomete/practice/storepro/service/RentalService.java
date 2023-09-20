package panomete.practice.storepro.service;

import panomete.practice.storepro.dto.RentalDto;

import java.util.List;

public interface RentalService {
    List<RentalDto> getTop10Rentals();
}
