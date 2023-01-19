package com.ezolucion.prices.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricesOutException extends RuntimeException{
    private HttpStatus httpStatus;

    public PricesOutException(String message, HttpStatus status){
        super(message);
        this.httpStatus = status;
    }
}
