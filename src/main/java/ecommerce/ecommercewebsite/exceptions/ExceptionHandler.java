package ecommerce.ecommercewebsite.exceptions;

import ecommerce.ecommercewebsite.annotations.AllowExceptionHandler;
import ecommerce.ecommercewebsite.messages.ExceptionMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(annotations = AllowExceptionHandler.class)
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ProvidedElementIsNullException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> handleProvidedElementIsNullException(ProvidedElementIsNullException e) {
        return returnErrorMessage(ExceptionMessages.ELEMENT_IS_NULL, HttpStatus.NO_CONTENT);
    }

    private ResponseEntity<String> returnErrorMessage(String message, HttpStatus status) {
        return new ResponseEntity<String>(message, status);
    }
}
