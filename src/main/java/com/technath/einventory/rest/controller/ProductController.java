package com.technath.einventory.rest.controller;

import com.technath.einventory.exception.DataSaveException;
import com.technath.einventory.exception.EntityNotFoundException;
import com.technath.einventory.exception.ValidationErrorException;
import com.technath.einventory.rest.request.ProductDTO;
import com.technath.einventory.rest.request.SupplierDTO;
import com.technath.einventory.services.ProductService;
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
import java.math.BigInteger;
import java.util.List;

import static com.technath.einventory.util.LoggingUtil.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private static final String ADD_PRODUCT = "addProduct";
    private static final String GET_ALL_PRODUCT = "getAllProduct";
    private static final String GET_PRODUCT_BY_ID = "getProductById";


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
//    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductDTO productDTO,
                            HttpServletRequest request, HttpServletResponse response) throws ValidationErrorException, DataSaveException {
        LOGGER.info(API_DOMAIN_BASE, log(INVENTORY), log(PRODUCT), log(ADD_PRODUCT), log("Received Request"));
        productService.addProduct(productDTO);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public List<ProductDTO> getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ValidationErrorException, DataSaveException {
        LOGGER.info(API_DOMAIN_BASE, log(INVENTORY), log(PRODUCT), log(GET_ALL_PRODUCT), log("Received Request"));
        return productService.getAllProduct();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ProductDTO getProductByProductId(@PathVariable(value="id") BigInteger id, HttpServletRequest request, HttpServletResponse response)
            throws ValidationErrorException, DataSaveException, EntityNotFoundException {
        LOGGER.info(API_DOMAIN_BASE, log(INVENTORY), log(PRODUCT), log(GET_PRODUCT_BY_ID), log("Received Request"));
        return productService.findProductById(id);
    }
}
