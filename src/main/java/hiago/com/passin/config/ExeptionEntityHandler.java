package hiago.com.passin.config;

import hiago.com.passin.domain.attendee.exceptions.AttendeeAlreadyExistException;
import hiago.com.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import hiago.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsExeption;
import hiago.com.passin.domain.event.exceptions.EventFullException;
import hiago.com.passin.domain.event.exceptions.EventNotFoundExeption;

import hiago.com.passin.dto.general.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionEntityHandler {
    @ExceptionHandler(EventNotFoundExeption.class)
    public ResponseEntity handleEventNotFound(EventNotFoundExeption exeption){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException exception){
       return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(AttendeeAlreadyExistException.class)
    public ResponseEntity handleAttendeeAlreadyExist(AttendeeAlreadyExistException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @ExceptionHandler(CheckInAlreadyExistsExeption.class)
    public ResponseEntity handleCheckInAlreadyExist( CheckInAlreadyExistsExeption exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @ExceptionHandler(EventFullException.class)
    public  ResponseEntity<ErrorResponseDTO> handleEvenetFull(EventFullException exception){
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
    }
}
