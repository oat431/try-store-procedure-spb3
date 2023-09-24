package panomete.practice.storepro.exception;

import java.sql.Timestamp;

public record ExceptionMessageDto(
        Timestamp timestamp,
        Integer status,
        String error,
        String message,
        String path
) {
}
