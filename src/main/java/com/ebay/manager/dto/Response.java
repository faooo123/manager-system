package com.ebay.manager.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Response<T> {
    private String code;
    private String message;
    private T data;
}