package com.cydeo.mapper;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ProjectMapper {

    private final ModelMapper modalMapper;

    public ProjectMapper(ModelMapper modalMapper) {
        this.modalMapper = modalMapper;
    }

    public Project convertToEntity(ProjectDTO dto){
        return modalMapper.map(dto, Project.class);
    }

    public ProjectDTO convertToDTO(Project entity){
        return modalMapper.map(entity, ProjectDTO.class);
    }

}
