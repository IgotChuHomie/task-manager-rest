package com.taskifyrestapi.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.taskifyrestapi.application.dto.UserDTO;
import com.taskifyrestapi.application.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "token", ignore = true)
    UserDTO toUserDto(User user);

}
