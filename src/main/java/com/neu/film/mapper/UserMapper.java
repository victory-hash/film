package com.neu.film.mapper;

import com.neu.film.pojo.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT U_ID uId,U_NAME uName,U_PWD uPwd FROM user WHERE U_NAME=#{uName}")
    UserEntity findUserByName(String uName)throws Exception;

    @Insert("INSERT INTO user(U_NAME,U_PWD,U_BIRTH) values(#{uName},#{uPwd},#{uBirth})")
    int addUser(UserEntity userEntity);

}
