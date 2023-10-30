package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@ToString
@Builder
public class BranchDto {
    private Integer branchId;
    private String address;
    private String zipCode;

    public BranchDto(Integer branchId, String address, String zipCode) {
        this.branchId = branchId;
        this.address = address;
        this.zipCode = zipCode;
    }
}
