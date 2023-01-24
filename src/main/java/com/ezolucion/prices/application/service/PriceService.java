package com.ezolucion.prices.application.service;

import com.ezolucion.prices.common.exception.PricesInException;
import com.ezolucion.prices.domain.in.PriceRequest;
import com.ezolucion.prices.domain.in.PricesFindRequest;
import com.ezolucion.prices.domain.out.PricesFindResponse;
import com.ezolucion.prices.domain.out.PricesResponse;
import com.ezolucion.prices.infraestructure.rest.cases.PriceFindCase;
import com.ezolucion.prices.infraestructure.rest.cases.PriceSaveCase;
import com.ezolucion.prices.infraestructure.rest.port.PriceFindPort;
import com.ezolucion.prices.infraestructure.rest.port.PriceSavePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PriceService implements PriceSaveCase, PriceFindCase {

    @Autowired
    private PriceSavePort priceSavePort;

    @Autowired
    private PriceFindPort priceFindPort;


    private Validator validator;
    @Autowired
    public PriceService(Validator validator){
        this.validator = validator;
    }
    @Override
    public PricesFindResponse findPriceCase(PricesFindRequest priceFindRequest) {
        Set<ConstraintViolation<PricesFindRequest>> constraint = validator.validate(priceFindRequest);
        if(!constraint.isEmpty()){
            var constraintMessage = constraint.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
            var messageError = new StringBuilder().append("Se encontraron parametros con error: ").append(constraintMessage);
            log.error(messageError.toString());
            throw new PricesInException(messageError.toString(), HttpStatus.BAD_REQUEST);
        }
        var response = priceFindPort.findPricePort(priceFindRequest);
        return response;
    }

    @Override
    public PricesResponse priceSaveCase(PriceRequest price) {
        return null;
    }
}
