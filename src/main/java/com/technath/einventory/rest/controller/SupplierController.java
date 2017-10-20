package com.technath.einventory.rest.controller;

import com.technath.einventory.exception.ValidationErrorException;
import com.technath.einventory.rest.SupplierRequestValidator;
import com.technath.einventory.rest.request.SupplierDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;

import static com.technath.einventory.util.LoggingUtil.*;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierRequestValidator supplierRequestValidator;


    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);

    private static final String ADD_SUPPLIER = "addSupplier";

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
//    @ResponseStatus(HttpStatus.CREATED)
    public void addSupplier(@RequestBody SupplierDTO supplierDTO,
                            HttpServletRequest request, HttpServletResponse response) throws ValidationErrorException {
        LOGGER.info(API_DOMAIN_BASE, log(INVENTORY), log(SUPPLIER), log(ADD_SUPPLIER), log("Received Request"));
        supplierRequestValidator.validateNewSupplier(supplierDTO);
    }


}
