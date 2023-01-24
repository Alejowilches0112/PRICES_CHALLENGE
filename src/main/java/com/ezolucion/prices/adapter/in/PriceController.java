package com.ezolucion.prices.adapter.in;

import com.ezolucion.prices.domain.in.PriceRequest;
import com.ezolucion.prices.domain.in.PricesFindRequest;
import com.ezolucion.prices.domain.out.PricesFindResponse;
import com.ezolucion.prices.domain.out.PricesResponse;
import com.ezolucion.prices.infraestructure.rest.cases.PriceFindCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PriceController implements IPriceController{

    @Autowired
    private PriceFindCase priceFind;
    @Override
    public ResponseEntity<PricesFindResponse> priceFind(PricesFindRequest priceFindRequest) {
        var price = priceFind.findPriceCase(priceFindRequest);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PricesResponse> priceSave(PriceRequest priceRequest) {
        return IPriceController.super.priceSave(priceRequest);
    }
}
