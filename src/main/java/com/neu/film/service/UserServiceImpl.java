package com.neu.film.service;

import com.neu.film.mapper.UserMapper;
import com.neu.film.pojo.FilmInfoEntity;
import com.neu.film.pojo.ResultDTO;
import com.neu.film.pojo.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service("/UserService")
public class UserServiceImpl implements UserService{

    @Resource
    UserMapper userMapper;
    @Override
    public ResultDTO<UserEntity> checkLogin(UserEntity userEntity) throws Exception {
        ResultDTO<UserEntity> loginResult = new ResultDTO<UserEntity>();
        UserEntity getUser = userMapper.findUserByName(userEntity.getuName());
        List<UserEntity> datas = new ArrayList<UserEntity>();
        if(null==getUser){
            loginResult.setCode(1001);
            loginResult.setMsg("nameErr");
            datas.add(userEntity);
        }else{
            if(getUser.getuPwd().equals(userEntity.getuPwd())){
                loginResult.setCode(888);
                loginResult.setMsg("success");
                datas.add(getUser);
            }else {
                loginResult.setCode(1002);
                loginResult.setMsg("pwdErr");
                datas.add(userEntity);
            }
        }
        loginResult.setData(datas);
        return loginResult;
    }


    @Override
    public ResultDTO<UserEntity> regist(UserEntity userEntity) throws Exception {
        ResultDTO<UserEntity> loginResult = new ResultDTO<UserEntity>();
        UserEntity getUser = userMapper.findUserByName(userEntity.getuName());
        if(null==getUser){
            int i = userMapper.addUser(userEntity);
            if(i>0){
                loginResult.setCode(1);
                loginResult.setMsg("success");
            }else{
                loginResult.setCode(2);
                loginResult.setMsg("fail");
            }
        }else{
            loginResult.setCode(3);
            loginResult.setMsg("userExist");
        }
        List<UserEntity> datas = new ArrayList<UserEntity>();
        datas.add(userEntity);
        loginResult.setData(datas);
        return loginResult;
    }
}
