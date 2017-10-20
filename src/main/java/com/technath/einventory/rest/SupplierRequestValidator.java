package com.technath.einventory.rest;

import com.technath.einventory.exception.ValidationErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.apache.commons.lang3.Validate;

import static com.technath.einventory.util.LoggingUtil.*;

@Component
public class SupplierRequestValidator {

    public static final String VALIDATOR = "Request Validator";
    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierRequestValidator.class);

    public void validateNewSupplier(com.technath.einventory.rest.request.SupplierDTO supplierDTO) throws ValidationErrorException {
        try {
            Validate.notBlank(supplierDTO.getSupplierName(), "Supplier Name cannot be Null");
            Validate.notNull(supplierDTO.getPhone1(), "Phone1 cannot be Null");
            Validate.notNull(supplierDTO.getEmail(), "Email cannot be Null");
        } catch (IllegalArgumentException | NullPointerException e) {
            LOGGER.error(API_DOMAIN_BASE, log(INVENTORY), log(ADD_SUPPLIER),
                    log(VALIDATOR), withErrorMessage("Validation Failure", e));
            throw new ValidationErrorException(e.getLocalizedMessage());
        }
    }
}
