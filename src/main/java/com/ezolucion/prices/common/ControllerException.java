package com.ezolucion.prices.common;

import com.ezolucion.prices.common.exception.PricesInException;
import com.ezolucion.prices.common.exception.PricesOutException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {
    @ExceptionHandler(value = PricesInException.class)
    public ResponseEntity<String> runtTimeExceptionExc(PricesInException pricesInException){
        return new ResponseEntity<>(pricesInException.getMessage(), pricesInException.getHttpStatus());
    }

    @ExceptionHandler(value = PricesOutException.class)
    public ResponseEntity<String> runtTimeExceptionExc(PricesOutException pricesOutException){
        return new ResponseEntity<>(pricesOutException.getMessage(), pricesOutException.getHttpStatus());
    }
}
