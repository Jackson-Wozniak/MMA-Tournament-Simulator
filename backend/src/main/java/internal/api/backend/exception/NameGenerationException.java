package internal.api.backend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NameGenerationException extends RuntimeException{
    public final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public NameGenerationException(String message){
        super(message);
    }
}
