package com.example.demo.model.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {
    private String message;
    private Object object;
}
