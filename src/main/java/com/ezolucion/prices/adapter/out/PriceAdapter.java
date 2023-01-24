package com.ezolucion.prices.adapter.out;

import com.ezolucion.prices.infraestructure.db.repository.IPriceRepository;
import com.ezolucion.prices.common.exception.PricesInException;
import com.ezolucion.prices.domain.mapper.PriceMapper;
import com.ezolucion.prices.domain.in.PriceRequest;
import com.ezolucion.prices.domain.in.PricesFindRequest;
import com.ezolucion.prices.domain.out.PricesFindResponse;
import com.ezolucion.prices.domain.out.PricesResponse;
import com.ezolucion.prices.infraestructure.rest.port.PriceFindPort;
import com.ezolucion.prices.infraestructure.rest.port.PriceSavePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Slf4j
public class PriceAdapter implements PriceSavePort, PriceFindPort {

    @Autowired
    private IPriceRepository priceRepository;
    @Autowired
    private PriceMapper priceMapper;
    @Override
    public PricesFindResponse findPricePort(PricesFindRequest priceFind) {
        var pricesList = priceRepository.findByIdBrandAndIdProductAndStartDateOrderByPriceAsc(priceFind.getIdBrand(), priceFind.getIdProduct(), priceFind.getDateApplication());
        if(pricesList.isEmpty()){
            log.info("No se encontraron resultados con los parametros de busqueda.");
            throw new PricesInException("No se encontraron resultados con los parametros de busqueda.", HttpStatus.NOT_FOUND);
        }
        var totalList = pricesList.size() - 1;
        var response = PricesFindResponse.builder()
                .listPrice(pricesList.get(totalList).getPriceList())
                .price(pricesList.get(totalList).getPrice())
                .idProduct(pricesList.get(totalList).getIdProduct())
                .idBrand(pricesList.get(totalList).getIdBrand())
                .dateInit(pricesList.get(totalList).getStartDate())
                .dateEnd(pricesList.get(totalList).getEndDate())
                .build();
        return response;
    }

    @Override
    @Transactional
    public PricesResponse priceSavePort(PriceRequest price) {
        var priceEntity = priceMapper.toEntityRequest(price);
        var message = "Creado con exito";
        priceEntity = priceRepository.save(priceEntity);
        if (priceEntity.getId() == null){
            message = " Error creando";
        }
        var priceResponse = PricesResponse.builder().message(message).build();
        return priceResponse;
    }
}
