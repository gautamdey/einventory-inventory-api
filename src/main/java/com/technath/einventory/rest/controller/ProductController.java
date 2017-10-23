package com.technath.einventory.rest.controller;

import com.technath.einventory.exception.DataSaveException;
import com.technath.einventory.exception.EntityNotFoundException;
import com.technath.einventory.exception.ValidationErrorException;
import com.technath.einventory.rest.request.SupplierDTO;
import com.technath.einventory.services.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.technath.einventory.util.LoggingUtil.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    SupplierService supplierService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private static final String ADD_SUPPLIER = "addSupplier";


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
//    @ResponseStatus(HttpStatus.CREATED)
    public void addSupplier(@RequestBody SupplierDTO supplierDTO,
                            HttpServletRequest request, HttpServletResponse response) throws ValidationErrorException, DataSaveException {
        LOGGER.info(API_DOMAIN_BASE, log(INVENTORY), log(SUPPLIER), log(ADD_SUPPLIER), log("Received Request"));
        supplierService.addSupplier(supplierDTO);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public List<SupplierDTO> getSuppliers(HttpServletRequest request, HttpServletResponse response) throws ValidationErrorException, DataSaveException {
        LOGGER.info(API_DOMAIN_BASE, log(INVENTORY), log(SUPPLIER), log(ADD_SUPPLIER), log("Received Request"));
        return supplierService.getAllSupliers();
    }

    @RequestMapping(value = "/{supplierId}",
            method = RequestMethod.GET,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public SupplierDTO getSupplierBySupplierId(@PathVariable(value="supplierId") Long supplierId, HttpServletRequest request, HttpServletResponse response)
            throws ValidationErrorException, DataSaveException, EntityNotFoundException {
        LOGGER.info(API_DOMAIN_BASE, log(INVENTORY), log(SUPPLIER), log(ADD_SUPPLIER), log("Received Request"));
        return supplierService.findSupplierBySupplierId(supplierId);
    }
}
