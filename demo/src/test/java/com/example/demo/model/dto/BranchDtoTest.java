package com.example.demo.model.dto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BranchDtoTest {

    @Test
    public void testConstructor() {
        Integer branchId = 1;
        String address = "123 Main St";
        String zipCode = "10001";

        BranchDto branchDto = new BranchDto(branchId, address, zipCode);

        assertNotNull(branchDto);
        assertEquals(branchId, branchDto.getBranchId());
        assertEquals(address, branchDto.getAddress());
        assertEquals(zipCode, branchDto.getZipCode());
    }

    @Test
    public void testBuilder() {
        Integer branchId = 1;
        String address = "123 Main St";
        String zipCode = "10001";

        BranchDto branchDto = BranchDto.builder()
                .branchId(branchId)
                .address(address)
                .zipCode(zipCode)
                .build();

        assertNotNull(branchDto);
        assertEquals(branchId, branchDto.getBranchId());
        assertEquals(address, branchDto.getAddress());
        assertEquals(zipCode, branchDto.getZipCode());
    }
}




