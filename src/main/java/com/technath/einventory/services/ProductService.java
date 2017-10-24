package com.technath.einventory.services;

import com.technath.einventory.dao.model.Product;
import com.technath.einventory.dao.model.Supplier;
import com.technath.einventory.dao.repository.ProductRepository;
import com.technath.einventory.dao.repository.SupplierRepository;
import com.technath.einventory.exception.DataSaveException;
import com.technath.einventory.exception.EntityNotFoundException;
import com.technath.einventory.exception.ValidationErrorException;
import com.technath.einventory.rest.ProductRequestValidator;
import com.technath.einventory.rest.SupplierRequestValidator;
import com.technath.einventory.rest.controller.ProductController;
import com.technath.einventory.rest.controller.SupplierController;
import com.technath.einventory.rest.request.ProductDTO;
import com.technath.einventory.rest.request.SupplierDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.technath.einventory.util.LoggingUtil.*;
import static java.lang.String.join;

@Service
public class ProductService {
    @Autowired
    private ProductRequestValidator productRequestValidator;

    @Autowired
    private ProductRepository productRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private static final String ADD_PRODUCT = "addProduct";
    private static final String GET_PRODUCT = "getProductById";
    private static final String PRODUCT_ID = " productId={}";

    public Product addProduct(final ProductDTO productDTO) throws ValidationErrorException, DataSaveException {
        productRequestValidator.validateProductRequest(productDTO);
        Product savedProduct = null;
        ModelMapper modelMapper = new ModelMapper();
        try {
            Product product = modelMapper.map(productDTO, Product.class);
            product.setId(null);
            savedProduct = productRepository.save(product);
            LOGGER.info(join(API_DOMAIN_BASE, PRODUCT_ID), log(INVENTORY), log(ADD_PRODUCT), log("addProduct"),
                    log("Added  Product "), log(PRODUCT_ID), savedProduct.getId());
        } catch (Exception ex) {
            LOGGER.error(API_DOMAIN_BASE, log(INVENTORY), log(ADD_PRODUCT), log("addProduct"),
                    log("Error adding Product "));
            throw new DataSaveException(ex.getMessage());
        }
        return savedProduct;
    }

    public List<ProductDTO> getAllProduct() {
        ModelMapper modelMapper = new ModelMapper();
        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
        Iterable<Product> productList = productRepository.findAll();
        productList.forEach((k) -> {
            productDTOS.add(modelMapper.map(k, ProductDTO.class));
        });
        return productDTOS;
    }

    public ProductDTO findProductById(BigInteger id) throws EntityNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        Product product = productRepository.findById(id);
        if (product == null) {
            LOGGER.info(join(API_DOMAIN_BASE, PRODUCT_ID), log(INVENTORY), log(GET_PRODUCT), log("findProductById"), id);
            throw new EntityNotFoundException(String.format("Produictid = %s not found", id));
        }
        return modelMapper.map(product, ProductDTO.class);
    }

}

