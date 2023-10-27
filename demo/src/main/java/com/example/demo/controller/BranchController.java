package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.model.entities.Branch;
import com.example.demo.service.IBranch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
public class BranchController {
    private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

    private final IBranch branchService;

    public BranchController(IBranch branchService) {
        this.branchService = branchService;
    }

    //Save branch
    @PostMapping("/branch")
    public Branch createBranch(@RequestBody Branch branch) {
        logger.info("Branch to create => " + branch);
        return branchService.save(branch);
    }

    //Get all branches
    @GetMapping("/branches")
    public List<Branch> listBranch() {
        return branchService.findAll();
    }

    //Delete a branch by id
    @DeleteMapping("/branch/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBranchById(
            @PathVariable String id
    ) {
        Branch branch = branchService.findById(Integer.parseInt(id));
        if (branch == null) {
            throw new ResourceNotFound("Branch with id '" + id + "' not found");
        }
        branchService.deleteById(branch.getBranchId());
        Map<String, Boolean> res = new HashMap<>();
        res.put("Branch deleted", Boolean.TRUE);
        return ResponseEntity.ok(res);
    }
}
