package panomete.practice.storepro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Rate might be out of range")
public class RateNotFoundException extends RuntimeException {
    public RateNotFoundException() {
        super();
    }

    public RateNotFoundException(String message) {
        super(message);
    }

}
