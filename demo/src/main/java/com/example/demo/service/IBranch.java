package com.example.demo.service;

import com.example.demo.model.dto.BranchDto;
import com.example.demo.model.entity.Branch;

import java.util.List;

public interface IBranch {

    Branch save(BranchDto branchDto);

    List<Branch> findAll();

    void deleteById(Integer id);

    Branch findById(Integer idBranch);

    Branch findByAddress(String branchAddress);
}
