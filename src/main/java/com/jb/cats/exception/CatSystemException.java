package com.jb.cats.exception;

public class CatSystemException extends Exception{

    public CatSystemException(ErrMsg errMsg){
        super(errMsg.getMessage());
    }
}