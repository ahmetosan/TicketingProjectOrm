package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> listAllProject();
    void save(ProjectDTO dto);
}
