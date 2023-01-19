package com.ezolucion.prices.infraestructure.db.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Price")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idBrand;

    private Date startDate;

    private Date endDate;

    private Long priceList;

    private long idProduct;

    private Long priority;

    private BigDecimal price;

    private String currency;
}
