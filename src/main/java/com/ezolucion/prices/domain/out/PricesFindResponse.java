package com.ezolucion.prices.domain.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PricesFindResponse {

    @JsonProperty("producto_id")
    private Long idProduct;

    @JsonProperty("brand_id")
    private Long idBrand;
    @JsonProperty("tarifa_aplica")
    private Long listPrice;
    @JsonProperty("fecha_inicial")
    private Date dateInit;
    @JsonProperty("fecha_fin")
    private Date dateEnd;
    @JsonProperty("precio_final")
    private BigDecimal price;
}
