package com.ezolucion.prices.domain.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PriceRequest {
    @NotNull(message = "El campo brand_id es obligatorio")
    @JsonProperty("brand_id")
    private Long brandId;
    @NotNull(message = "El campo fecha_inicial es obligatorio")
    @JsonProperty("fecha_inicial")
    private Date startDate;
    @NotNull(message = "El campo fecha_final es obligatorio")
    @JsonProperty("fecha_final")
    private Date endDate;
    @NotNull(message = "El campo lista_precios es obligatorio")
    @JsonProperty("lista_precios")
    private Long priceList;
    @NotNull(message = "El campo producto_id es obligatorio")
    @JsonProperty("producto_id")
    private Long productId;
    @NotNull(message = "El campo prioridad es obligatorio")
    @JsonProperty("prioridad")
    private Long priority;
    @NotNull(message = "El campo precio es obligatorio")
    @JsonProperty("precio")
    private BigDecimal price;
    @NotEmpty(message = "El campo moneda no puede estar vacio")
    @JsonProperty("moneda")
    private String currency;
}
