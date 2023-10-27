package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class BranchDto {
    private Integer branchId;
    private String address;
    private String zipCode;
}
