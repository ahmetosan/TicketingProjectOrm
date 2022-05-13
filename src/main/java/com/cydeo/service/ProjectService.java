package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO getByProjectCode(String code);
    List<ProjectDTO> listAllProject();

    void save(ProjectDTO dto);
    void update(ProjectDTO dto);
    void delete(ProjectDTO dto);

}
