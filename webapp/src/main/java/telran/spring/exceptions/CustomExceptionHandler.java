package telran.spring.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<List<String>> handleAllExceptions(Exception ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
  }
 
  @ExceptionHandler(EmptyResultDataAccessException.class)
  public final ResponseEntity<List<String>> handleUserNotFoundException(EmptyResultDataAccessException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
  }
}