package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;
   private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<UserDTO> listAllUser() {

        List<User> userList = userRepository.findAll(Sort.by("firstName"));
        return userList.stream().map(userMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String userName) {

        User user = userRepository.findByUserName(userName);
        return userMapper.convertToDto(user);
    }

    @Override
    public void save(UserDTO dto) {

        userRepository.save(userMapper.convertToEntity(dto));


    }

    @Override
    public UserDTO update(UserDTO dto) {

        //Find current user
        User user = userRepository.findByUserName(dto.getUserName());
        //
        User covertedUser = userMapper.convertToEntity(dto);

        covertedUser.setId(user.getId());

        userRepository.save(covertedUser);
 //       userRepository.save(userMapper.convertToEntity(dto));

        return  findByUserName(dto.getUserName());
    }

    @Override
    public void deleteByUserName(String username) {

        userRepository.deleteByUserName(username);

    }

    @Override
    public void delete(String username) {

        User user = userRepository.findByUserName(username);
        user.setIsDeleted(true);
        userRepository.save(user);


    }

    @Override
    public List<UserDTO> findManagers() {
        return listAllUser().stream().filter(user->user.getRole().getDescription().
                equals("MANAGER")).collect(Collectors.toList());
    }
}
