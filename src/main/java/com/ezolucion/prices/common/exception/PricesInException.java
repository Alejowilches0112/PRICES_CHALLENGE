package com.ezolucion.prices.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricesInException extends RuntimeException{
    private HttpStatus httpStatus;

    public PricesInException(String message, HttpStatus status){
        super(message);
        this.httpStatus = status;
    }
}
