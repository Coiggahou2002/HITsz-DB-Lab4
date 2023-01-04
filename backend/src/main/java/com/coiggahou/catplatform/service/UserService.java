package com.coiggahou.catplatform.service;

import com.coiggahou.catplatform.entity.ApiResponse;
import com.coiggahou.catplatform.entity.User;

public interface UserService {

    ApiResponse register(User user);

    ApiResponse login(User user);
}