package com.ezolucion.prices.adapter.in;

import com.ezolucion.prices.domain.in.PriceRequest;
import com.ezolucion.prices.domain.in.PricesFindRequest;
import com.ezolucion.prices.domain.out.PricesFindResponse;
import com.ezolucion.prices.domain.out.PricesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PriceController implements IPriceController{

    @Override
    public ResponseEntity<PricesFindResponse> priceFind(PricesFindRequest priceFindRequest) {
        return IPriceController.super.priceFind(priceFindRequest);
    }

    @Override
    public ResponseEntity<PricesResponse> priceSave(PriceRequest priceRequest) {
        return IPriceController.super.priceSave(priceRequest);
    }
}
