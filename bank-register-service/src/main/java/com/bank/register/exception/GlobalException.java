/*
 * package com.bank.register.exception;
 * 
 * import java.util.Date;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.context.request.WebRequest; import
 * org.springframework.web.servlet.mvc.method.annotation.
 * ResponseEntityExceptionHandler;
 * 
 * import com.bank.register.dto.ErrorDetails;
 * 
 * 
 * 
 * @ControllerAdvice public class GlobalException extends
 * ResponseEntityExceptionHandler{
 * 
 * @ExceptionHandler public ResponseEntity<ErrorDetails>
 * hadleResourceNotFoundException(ResourceNotFoundException exception,WebRequest
 * webRequest){ ErrorDetails errorDetails = new ErrorDetails(new Date(),
 * exception.getMessage(), webRequest.getDescription(false)); return new
 * ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
 * 
 * }
 * 
 * }
 */