package com.ezolucion.prices.infraestructure.rest.port;

import com.ezolucion.prices.domain.in.PricesFindRequest;
import com.ezolucion.prices.domain.out.PricesFindResponse;

public interface PriceFindPort {

    PricesFindResponse findPricePort(PricesFindRequest priceFind);
}
