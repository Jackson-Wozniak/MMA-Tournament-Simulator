package internal.api.backend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NameGenerationException.class)
    public ResponseEntity<String> nameGenerationException(NameGenerationException ex){
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }

}
