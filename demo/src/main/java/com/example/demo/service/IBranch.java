package com.example.demo.service;

import com.example.demo.model.entities.Branch;

import java.util.List;

public interface IBranch {

    Branch save(Branch branch);

    List<Branch> findAll();

    void deleteById(Integer id);

    Branch findById(Integer idBranch);
}
