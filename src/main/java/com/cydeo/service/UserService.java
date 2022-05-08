package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService  {


    List<UserDTO> listAllUser();
    UserDTO findByUserName(String userName);
    void save(UserDTO dto);
    UserDTO update(UserDTO dto);
    void deleteByUserName(String username);
    void delete(String username);

   List<UserDTO>  findManagers();
}
