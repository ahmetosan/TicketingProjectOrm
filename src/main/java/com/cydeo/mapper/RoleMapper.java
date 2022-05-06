package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modalMapper;

    public RoleMapper(ModelMapper modalMapper) {
        this.modalMapper = modalMapper;
    }


    public Role convertToEntity(RoleDTO dto){

        return modalMapper.map(dto,Role.class);
    }

    public RoleDTO convertToDto(Role Entity){

        return modalMapper.map(Entity,RoleDTO.class);

    }
}
