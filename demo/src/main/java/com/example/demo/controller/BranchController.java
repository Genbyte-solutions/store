package com.example.demo.controller;

import com.example.demo.mapper.BranchMapper;
import com.example.demo.model.dto.BranchDto;
import com.example.demo.model.entity.Branch;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.IBranch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class BranchController {
    private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

    private final IBranch branchService;
    private final BranchMapper branchMapper;

    public BranchController(IBranch branchService, BranchMapper branchMapper) {
        this.branchService = branchService;
        this.branchMapper = branchMapper;
    }

    //Save branch
    @PostMapping("/branch")
    public ResponseEntity<?> createBranch(@RequestBody BranchDto branchDto) {
        Branch findBranch = branchService.findByAddress(branchDto.getAddress());

        logger.info("branchDTO" + branchDto);
        logger.info("Branch to create => " + findBranch);

        if(findBranch != null){
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("This branch already exist")
                    .build(), HttpStatus.CONFLICT);
        }

        Branch newBranch = branchService.save(branchDto);

        branchDto = branchMapper.toDTO(newBranch);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("A new branch has been added")
                .object(branchDto)
                .build(), HttpStatus.CREATED);
    }

    //Get all branches
    @GetMapping("/branches")
    public ResponseEntity<?> findAll() {
        List<Branch> branches = branchService.findAll();
        logger.info("Branches obtained => " + branches);

        if (branches.isEmpty()) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("No records found")
                    .build(), HttpStatus.NOT_FOUND);
        }

        List<BranchDto> branchDtos = branchMapper.toDTOs(branches);

        return new ResponseEntity<>(ResponseMessage.builder()
                .object(branchDtos)
                .build(), HttpStatus.OK);
    }

    //Delete a branch by id
    @DeleteMapping("/branch/{id}")
    public ResponseEntity<?> deleteBranchById(
            @PathVariable("id") Integer id
    ) {
        branchService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
