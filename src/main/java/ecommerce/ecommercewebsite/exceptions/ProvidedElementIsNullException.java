package ecommerce.ecommercewebsite.exceptions;

import ecommerce.ecommercewebsite.messages.ExceptionMessages;

public class ProvidedElementIsNullException extends Throwable {
    public ProvidedElementIsNullException() {
        super(ExceptionMessages.ELEMENT_IS_NULL);
    }
}
