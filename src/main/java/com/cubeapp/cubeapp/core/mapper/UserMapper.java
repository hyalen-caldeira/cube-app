package com.cubeapp.cubeapp.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.cubeapp.cubeapp.core.dto.UserDto;
import com.cubeapp.cubeapp.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // ====================== Model to DTO
    UserDto mapModelToDto(UserModel model);

    // DTO to Model
    UserModel mapDtoToModel(UserDto dto);
}