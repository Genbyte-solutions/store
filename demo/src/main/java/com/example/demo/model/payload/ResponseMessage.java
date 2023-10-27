package com.example.demo.model.payload;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseMessage {
    private String message;
    private Object object;
}
