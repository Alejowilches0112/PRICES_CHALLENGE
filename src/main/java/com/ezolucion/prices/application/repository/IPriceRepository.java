package com.ezolucion.prices.application.repository;

import com.ezolucion.prices.infraestructure.db.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Long> {
    Optional<PriceEntity> findByIdBrandAndIdProductAndStartDate(Long idBrand, Long idProduct, Date startDate);

}