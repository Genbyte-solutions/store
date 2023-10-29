package com.example.demo.model.entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BranchTest {

    private Branch branch;

    @BeforeEach
    public void setUp() {
        branch = new Branch();
        branch.setBranchId(1);
        branch.setAddress("123 Main St");
        branch.setZipCode("10001");
    }

    @Test
    public void testBranchId() {
        assertEquals(1, branch.getBranchId());
    }

    @Test
    public void testAddress() {
        assertEquals("123 Main St", branch.getAddress());
    }

    @Test
    public void testZipCode() {
        assertEquals("10001", branch.getZipCode());
    }

    @Test
    public void testNoArgsConstructor() {
        Branch newBranch = new Branch();
        assertNotNull(newBranch);
    }

    @Test
    public void testAllArgsConstructor() {
        Branch anotherBranch = new Branch(2, "456 Elm St", "20002");
        assertNotNull(anotherBranch);
    }
}