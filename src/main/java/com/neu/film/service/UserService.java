package com.neu.film.service;

import com.neu.film.pojo.FilmInfoEntity;
import com.neu.film.pojo.ResultDTO;
import com.neu.film.pojo.UserEntity;

import java.util.List;

public interface UserService {
    ResultDTO<UserEntity> checkLogin (UserEntity userEntity) throws Exception;

    public ResultDTO<UserEntity> regist(UserEntity userEntity)throws Exception;


}
