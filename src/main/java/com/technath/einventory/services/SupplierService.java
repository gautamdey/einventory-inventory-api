package com.technath.einventory.services;

import com.technath.einventory.dao.model.Supplier;
import com.technath.einventory.exception.DataSaveException;
import com.technath.einventory.exception.EntityNotFoundException;
import com.technath.einventory.exception.ValidationErrorException;
import com.technath.einventory.rest.SupplierRequestValidator;
import com.technath.einventory.rest.controller.SupplierController;
import com.technath.einventory.rest.request.SupplierDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.technath.einventory.dao.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.List;

import static com.technath.einventory.util.LoggingUtil.*;
import static com.technath.einventory.util.LoggingUtil.log;
import static java.lang.String.join;

@Service
public class SupplierService {
    @Autowired
    private SupplierRequestValidator supplierRequestValidator;

    @Autowired
    private SupplierRepository supplierRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);
    private static final String ADD_SUPPLIER = "addSupplier";
    private static final String GET_SUPPLIER = "getSupplierById";
    private static final String SUPPLIER_ID = " supplierId={}";

    public void addSupplier(final SupplierDTO supplierDTO) throws ValidationErrorException, DataSaveException {
        supplierRequestValidator.validateNewSupplier(supplierDTO);
        ModelMapper modelMapper = new ModelMapper();
        try {
            Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
            supplier.setSupplierId(null);
            Supplier savedSupplier = supplierRepository.save(supplier);
            LOGGER.info(join(API_DOMAIN_BASE, SUPPLIER_ID), log(INVENTORY), log(SUPPLIER), log(ADD_SUPPLIER),
                    log("Added  Supplier "), log(SUPPLIER_ID), savedSupplier.getSupplierId());
        } catch (Exception ex) {
            LOGGER.error(API_DOMAIN_BASE, log(INVENTORY), log(SUPPLIER), log(ADD_SUPPLIER),
                    log("Error adding Supplier "));
            throw new DataSaveException(ex.getMessage());
        }
    }

    public List<SupplierDTO> getAllSupliers() {
        ModelMapper modelMapper = new ModelMapper();
        List<SupplierDTO> supplierDTOS = new ArrayList<SupplierDTO>();
        Iterable<Supplier> supplierList = supplierRepository.findAll();
        supplierList.forEach((k)->{
            supplierDTOS.add(modelMapper.map(k,SupplierDTO.class));
        });
        return supplierDTOS;
    }

    public SupplierDTO findSupplierBySupplierId(Long supplierId) throws EntityNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        Supplier supplier =  supplierRepository.findBySupplierId(supplierId);
        if(supplier==null) {
            LOGGER.info(join(API_DOMAIN_BASE,SUPPLIER_ID),log(INVENTORY),log(SUPPLIER),log(GET_SUPPLIER),supplierId);
            throw new EntityNotFoundException(String.format("Supplierid = %s not found",supplierId));
        }
        return  modelMapper.map(supplier,SupplierDTO.class);
    }

}

