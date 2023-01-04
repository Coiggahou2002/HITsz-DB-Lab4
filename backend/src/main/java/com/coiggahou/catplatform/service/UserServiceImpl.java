package com.coiggahou.catplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coiggahou.catplatform.entity.ApiResponse;
import com.coiggahou.catplatform.entity.ApiResponseStatus;
import com.coiggahou.catplatform.entity.User;
import com.coiggahou.catplatform.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private boolean exist(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User mayExistUser = userMapper.selectOne(wrapper);
        return mayExistUser != null;
    }

    @Override
    public ApiResponse register(User user) {
        if (exist(user.getUsername())) {
            return ApiResponse.ofStatus(ApiResponseStatus.REGISTER_FAILED);
        }
        userMapper.insert(user);
        return ApiResponse.ofStatus(ApiResponseStatus.SUCCESS);
    }

    @Override
    public ApiResponse login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", user.getPassword());
        User getUser = userMapper.selectOne(wrapper);
        if (getUser == null) {
            return ApiResponse.ofStatus(ApiResponseStatus.USERNAME_OR_PASSWORD_ERROR);
        }
        return ApiResponse.ofStatusAndData(ApiResponseStatus.SUCCESS, getUser.getId());
    }
}
