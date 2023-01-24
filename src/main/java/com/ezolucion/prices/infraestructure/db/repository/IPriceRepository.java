package com.ezolucion.prices.infraestructure.db.repository;

import com.ezolucion.prices.infraestructure.db.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Long> {
    List<PriceEntity> findByIdBrandAndIdProductAndStartDateOrderByPriceAsc(Long idBrand, Long idProduct, Date startDate);

}