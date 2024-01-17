package com.example.main.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Mary Njenga
 * KCB Group - BSS
 */
@AllArgsConstructor
@Getter
public enum TransactionStatusEnums {
    SUCCESS(0,"Success"),
    FAILURE(1,"Failure");

    private int code;
    private String message;

}
