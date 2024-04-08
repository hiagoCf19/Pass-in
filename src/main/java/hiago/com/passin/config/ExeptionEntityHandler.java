package hiago.com.passin.config;

import hiago.com.passin.domain.event.exceptions.EventNotFoundExeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionEntityHandler {
    @ExceptionHandler(EventNotFoundExeption.class)
    public ResponseEntity handleEventNotFound(EventNotFoundExeption exeption){
        return ResponseEntity.notFound().build();
    }
}
