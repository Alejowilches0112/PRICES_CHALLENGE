package com.ezolucion.prices.infraestructure.rest.cases;

import com.ezolucion.prices.domain.in.PriceRequest;
import com.ezolucion.prices.domain.out.PricesResponse;

public interface PriceSaveCase {
    PricesResponse priceSaveCase(PriceRequest price);
}
