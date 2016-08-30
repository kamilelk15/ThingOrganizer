package pl.enlight.thingorganizer.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Service exception
 * @author Kamil Żur
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Service has problem with this request")
public class ServiceException extends RuntimeException{
    
}
