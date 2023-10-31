package com.example.demo.mapper;

import com.example.demo.model.dto.BranchDto;
import com.example.demo.model.entity.Branch;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BranchMapper {
    public abstract BranchDto toDTO(Branch branch);

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

    public abstract Branch toEntity(BranchDto branchDto);
}
