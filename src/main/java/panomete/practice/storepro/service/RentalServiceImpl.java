package panomete.practice.storepro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import panomete.practice.storepro.dto.RateType;
import panomete.practice.storepro.dto.RentalDto;
import panomete.practice.storepro.repository.RentalJDBCRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    final RentalJDBCRepository rentalJDBCRepository;
    @Override
    public List<RentalDto> getTop10Rentals() {
        return rentalJDBCRepository.getTop10Rentals();
    }

    @Override
    public List<RentalDto> getTop10Rentals(RateType rate) {
        return rentalJDBCRepository.getTop10Rentals(rate.getRate());
    }
}
