package com.example.demo.repository;

import com.example.demo.model.entity.Branch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BranchRepository extends CrudRepository<Branch, Integer> {
    //Branch findByAddress(String branchAddress);

    @Query("SELECT b FROM Branch b WHERE b.address = :address")
    Branch findByAddress(@Param("address") String branchAddress);
}
