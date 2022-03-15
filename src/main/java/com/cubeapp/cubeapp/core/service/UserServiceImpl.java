package com.cubeapp.cubeapp.core.service;

import lombok.Setter;
import org.springframework.stereotype.Service;
import com.cubeapp.cubeapp.core.NotFoundException;
import com.cubeapp.cubeapp.core.dao.UserDao;
import com.cubeapp.cubeapp.core.dto.UserDto;
import com.cubeapp.cubeapp.core.mapper.UserMapper;
import com.cubeapp.cubeapp.model.UserModel;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Setter
    private static UserDao dao;

    UserMapper mapper = UserMapper.INSTANCE;

    // TODO
    @Override
    public List<UserModel> getAllUsers() {
        return (List<UserModel>) dao.findAll();
    }

    @Override
    public UserDto findByName(String name) {
        var model = dao.findByName(name).orElseThrow(NotFoundException::new);
        return mapper.mapModelToDto(model);
    }

    @Override
    public void update(UserDto dto) {
        dao.update(mapper.mapDtoToModel(dto));
    }

    @Override
    public UserDto create(UserDto dto) {
        UserModel model = dao.create(UserMapper.INSTANCE.mapDtoToModel(dto));
        return mapper.mapModelToDto(model);
    }

    @Override
    public Long deleteByName(String name) {
        return dao.deleteByName(name);
    }
}
