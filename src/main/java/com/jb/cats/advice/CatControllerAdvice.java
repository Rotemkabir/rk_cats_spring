package com.jb.cats.advice;

import com.jb.cats.exception.CatSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CatControllerAdvice {

    @ExceptionHandler(value = {CatSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails handle(Exception e){
        return new ErrDetails(e.getMessage());
    }
}
