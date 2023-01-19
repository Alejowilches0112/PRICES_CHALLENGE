package com.ezolucion.prices.common.mapper;

import com.ezolucion.prices.domain.in.PriceRequest;
import com.ezolucion.prices.domain.out.PricesFindResponse;
import com.ezolucion.prices.infraestructure.db.entity.PriceEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PriceMapper {

    public PriceEntity toEntityRequest(PriceRequest priceRequest){
        return PriceEntity.builder()
                .idBrand(priceRequest.getBrandId())
                .startDate(priceRequest.getStartDate())
                .endDate(priceRequest.getEndDate())
                .priceList(priceRequest.getPriceList())
                .idProduct(priceRequest.getProductId())
                .priority(priceRequest.getPriority())
                .price(priceRequest.getPrice())
                .currency(priceRequest.getCurrency())
                .build();
    }

    public PricesFindResponse toReponseEntity(PriceEntity priceEntity){
        return PricesFindResponse.builder()
                .idBrand(priceEntity.getIdBrand())
                .idProduct(priceEntity.getIdProduct())
                .price(priceEntity.getPrice())
                .dateInit(priceEntity.getStartDate())
                .dateEnd(priceEntity.getEndDate())
                .listPrice(priceEntity.getPriceList())
                .build();
    }
}
