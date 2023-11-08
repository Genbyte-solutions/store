package com.example.demo.mapper;

import com.example.demo.model.dto.BranchDto;
import com.example.demo.model.entity.Branch;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class BranchMapper {

    public BranchDto toDTO(Branch branch) {
        return BranchDto.builder()
                .branchId(branch.getBranchId())
                .address(branch.getAddress())
                .zipCode(branch.getZipCode())
                .build();
    }

    public List<BranchDto> toDTOs(List<Branch> branches) {
        if (branches == null) {
            return null;
        }

        List<BranchDto> list = new ArrayList<>();

        for (Branch branch : branches) {
            list.add(toDTO(branch));
        }

        return list;
    }

    public Branch toEntity(BranchDto branchDto) {
        return Branch.builder()
                .address(branchDto.getAddress())
                .zipCode(branchDto.getZipCode())
                .build();
    }
}
