package com.example.demo.mapper;

import com.example.demo.model.dto.BranchDto;
import com.example.demo.model.entities.Branch;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    BranchDto toDTO(Branch branch);

    List<BranchDto> toDTOs(List<Branch> branches);
}
