package panomete.practice.storepro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import panomete.practice.storepro.dto.RateType;
import panomete.practice.storepro.dto.RentalDto;
import panomete.practice.storepro.service.RentalService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/rentals")
@RequiredArgsConstructor
public class RentalController {
    final RentalService rentalService;

    @GetMapping("/r-top10")
    public ResponseEntity<List<RentalDto>> getTop10Rentals() {
        return ResponseEntity.ok(rentalService.getTop10Rentals());
    }

    @GetMapping("/top10")
    public ResponseEntity<List<RentalDto>> getTop10RentalsByRate(
            @RequestParam(name = "rate") RateType rate
    ) {
        return ResponseEntity.ok(rentalService.getTop10Rentals(rate));
    }
}
