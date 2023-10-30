package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(mappedBy = "fkBranchId")
    List<Invoice> invoices;

    @OneToMany(mappedBy = "fkBranchId")
    List<Product> products;
}
