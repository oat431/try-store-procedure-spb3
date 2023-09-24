package panomete.practice.storepro.service;

import panomete.practice.storepro.dto.RateType;
import panomete.practice.storepro.dto.RentalDto;

import java.util.List;

public interface RentalService {
    List<RentalDto> getTop10Rentals();
    List<RentalDto> getTop10Rentals(RateType rate);

    List<String> getAllRating();
}
