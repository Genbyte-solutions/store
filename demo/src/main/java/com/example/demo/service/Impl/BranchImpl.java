package com.example.demo.service.Impl;

import com.example.demo.mapper.BranchMapper;
import com.example.demo.model.dto.BranchDto;
import com.example.demo.model.entity.Branch;
import com.example.demo.repository.BranchRepository;
import com.example.demo.service.IBranch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchImpl implements IBranch {

    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    public BranchImpl(BranchRepository branchRepository, BranchMapper branchMapper) {

        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
    }

    @Transactional
    @Override
    public Branch save(BranchDto branchDto) {
        Branch branch = branchMapper.toEntity(branchDto);
        return branchRepository.save(branch);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        branchRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Branch findById(Integer idBranch) {

        return branchRepository.findById(idBranch).orElse(null);
    }
    @Transactional(readOnly = true)
    @Override
    public Branch findByAddress(String branchAddress) { return branchRepository.findByAddress(branchAddress); }

}
