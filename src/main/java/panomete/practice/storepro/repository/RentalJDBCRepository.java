package panomete.practice.storepro.repository;

import panomete.practice.storepro.dto.RentalDto;

import java.util.List;

public interface RentalJDBCRepository {
    List<RentalDto> getTop10Rentals();
    List<RentalDto> getTop10Rentals(String rate);

    List<String> getAllRating();
}
