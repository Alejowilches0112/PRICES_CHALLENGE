package com.ezolucion.prices.infraestructure.rest.cases;

import com.ezolucion.prices.domain.in.PricesFindRequest;
import com.ezolucion.prices.domain.out.PricesFindResponse;
import com.ezolucion.prices.domain.out.PricesResponse;

public interface PriceFindCase {
    PricesFindResponse findPriceCase(PricesFindRequest priceFindRequest);
}