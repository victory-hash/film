package com.neu.film.controller;

import com.neu.film.pojo.FilmInfoEntity;
import com.neu.film.pojo.ResultDTO;
import com.neu.film.pojo.UserEntity;
import com.neu.film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultDTO<UserEntity>login(@RequestBody UserEntity userEntity)throws Exception{
        System.out.println("vue发送的数据"+userEntity.getuName());
        ResultDTO<UserEntity> result = userService.checkLogin(userEntity);
        return result;
    }

    @PostMapping("/regist")
    public ResultDTO<UserEntity> regist(@RequestBody UserEntity userEntity)throws Exception{
        System.out.println("vue发送的数据"+userEntity);
        //调用UserService中  注册方法   根据返回值不同，返回不同结果 交由前台处理（暂时省略）
       return userService.regist(userEntity);
    }



}
