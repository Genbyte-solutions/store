package com.example.demo.repository;

import com.example.demo.model.entities.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch, Integer> {
}
