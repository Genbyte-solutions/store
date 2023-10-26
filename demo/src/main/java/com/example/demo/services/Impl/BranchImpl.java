package com.example.demo.services.Impl;

import com.example.demo.model.entities.Branch;
import com.example.demo.repository.BranchRepository;
import com.example.demo.services.IBranch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchImpl implements IBranch {

    private final BranchRepository branchRepository;

    public BranchImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        branchRepository.deleteById(id);
    }

    @Override
    public Branch findById(Integer idBranch) {
        return branchRepository.findById(idBranch).orElse(null);
    }
}
