package panomete.practice.storepro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import panomete.practice.storepro.dto.RateType;
import panomete.practice.storepro.dto.RentalDto;
import panomete.practice.storepro.exception.ExceptionMessageDto;
import panomete.practice.storepro.service.RentalService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/rentals")
@Tag(name = "Rental API", description = "All of the Rental API")
public class RentalController {
    final RentalService rentalService;

    @Operation(summary = "Get top 10 rentals")
    @ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = RentalDto.class)
                            )
                    )
            }
    )
    @GetMapping("/r-top10")
    public ResponseEntity<List<RentalDto>> getTop10Rentals() {
        return ResponseEntity.ok(rentalService.getTop10Rentals());
    }

    @Operation(summary = "Get top 10 rentals by rate")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful Operation",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = RentalDto.class)
                                    )
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Rate might be out of range",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionMessageDto.class)
                    )
            )
    })

    @GetMapping("/top10")
    public ResponseEntity<List<RentalDto>> getTop10RentalsByRate(
            @RequestParam(name = "rate") RateType rate
    ) {
        return ResponseEntity.ok(rentalService.getTop10Rentals(rate));
    }

    @Operation(summary = "Get all rating")
    @ApiResponse(
            responseCode = "200",
            description = "Successful Operation",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = String.class)
                            )
                    )
            }
    )
    @GetMapping("/rating")
    public ResponseEntity<List<String>> getAllRating() {
        return ResponseEntity.ok(rentalService.getAllRating());
    }
}
