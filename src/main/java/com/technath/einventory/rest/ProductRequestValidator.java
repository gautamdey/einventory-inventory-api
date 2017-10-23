package com.technath.einventory.rest;

import com.technath.einventory.exception.ValidationErrorException;
import com.technath.einventory.rest.request.ProductDTO;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.technath.einventory.util.LoggingUtil.*;

@Component
public class ProductRequestValidator {

    public static final String VALIDATOR = "Request Validator";
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRequestValidator.class);

    public void validateProductRequest(ProductDTO productDTO) throws ValidationErrorException {
        try {
            Validate.notBlank(productDTO.getName(), "Product Name cannot be Null");
            Validate.notNull(productDTO.getProductCode(), "Product code cannot be null");
        } catch (IllegalArgumentException | NullPointerException e) {
            LOGGER.error(API_DOMAIN_BASE, log(INVENTORY), log(ADD_SUPPLIER),
                    log(VALIDATOR), withErrorMessage("Validation Failure", e));
            throw new ValidationErrorException(e.getLocalizedMessage());
        }
    }
}
