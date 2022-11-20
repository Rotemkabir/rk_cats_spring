package com.jb.cats.exception;

import lombok.Getter;

@Getter
public enum ErrMsg {

    ID_NOT_FOUND("ha ha! - id not found"),
    ID_ALREADY_EXIST("ho ho! - id already exist"),
    WEIGHT_MUST_BE_GREATER_THAN_ZERO("ai ai - weight must br gt0");

    private String message;

    ErrMsg(String message) {
        this.message = message;
    }
}