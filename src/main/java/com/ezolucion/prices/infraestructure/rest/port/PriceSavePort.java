package com.ezolucion.prices.infraestructure.rest.port;

import com.ezolucion.prices.domain.in.PriceRequest;
import com.ezolucion.prices.domain.out.PricesResponse;

public interface PriceSavePort {

    PricesResponse priceSavePort(PriceRequest price);
}
