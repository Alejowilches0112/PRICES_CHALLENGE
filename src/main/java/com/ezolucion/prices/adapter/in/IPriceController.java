package com.ezolucion.prices.adapter.in;

import com.ezolucion.prices.domain.in.PriceRequest;
import com.ezolucion.prices.domain.in.PricesFindRequest;
import com.ezolucion.prices.domain.out.PricesFindResponse;
import com.ezolucion.prices.domain.out.PricesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IPriceController {

    @RequestMapping(
            value = "/findPrice",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<PricesFindResponse> priceFind(PricesFindRequest priceFindRequest){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(
            value = "createPrice",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<PricesResponse> priceSave(PriceRequest priceRequest){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
