package com.example.demo.controllers;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.model.entities.Branch;
import com.example.demo.services.Impl.BranchImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value= "/api/v1")
public class BranchController {
    private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

    @Autowired
    BranchImpl branch;

    //Save branch
    @PostMapping("/branches")
    public Branch createBranch(@RequestBody Branch branch){
        logger.info("Branch to create => "+ branch);
        return this.branch.save(branch);
    }

    //Get all branches
    @GetMapping("/branches")
    public List<Branch> listBranch(){
        return this.branch.findAll();
    }

    //Delete a branch by id
    @DeleteMapping("/branches/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteBranchById(
            @PathVariable int id
    ){
        Branch branch = this.branch.findById(id);
        if(branch == null){
            throw new ResourceNotFound("No se encontro el id: " + id);
        }
        this.branch.deleteById(branch.getBranchId());
        Map<String,Boolean> res = new HashMap<>();
        res.put("Branch deleted", Boolean.TRUE);
        return ResponseEntity.ok(res);
    }
}
