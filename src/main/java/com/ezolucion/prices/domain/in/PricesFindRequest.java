package com.ezolucion.prices.domain.in;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Date;

import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PricesFindRequest {

    @NotNull(message = "El campo fecha_aplicacion es obligatorio")
    @JsonProperty("fecha_aplicacion")
    private Date dateApplication;

    @NotNull(message = "el campo producto_id es obligatorio")
    @JsonProperty("producto_id")
    private Long idProduct;
    @NotNull(message = "el campo brand_id es obligatorio")
    @JsonProperty("brand_id")
    private Long idBrand;
}
