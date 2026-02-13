package com.assignment.rest.RestApiAssignment.Exception;

import com.assignment.rest.RestApiAssignment.errorDetails.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

//controlleradvice will run check the exception for each controller
@ControllerAdvice
public class GlobalExceptionHandler{
    //handling all the Runtime Exception
    @ExceptionHandler(RuntimeException.class)
    //returning the ResposneEntity object
    public final ResponseEntity<ErrorDetails> handleException(Exception ex, WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(), LocalDate.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }
}
