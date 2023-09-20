package panomete.practice.storepro.dto;

public record RentalDto(
        String title,
        String description,
        Integer releaseYear,
        Double rentalRate

) {
}

//    title varchar(255),
//    description text,
//    release_year year,
//    rental_rate numeric(4,2)
