package com.neu.film.controller;

import com.neu.film.pojo.FilmInfoEntity;
import com.neu.film.pojo.ResultDTO;
import com.neu.film.service.FilmInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/json/film")
public class JsonFilmInfoController {

    private static  final Logger logger = LoggerFactory.getLogger(JsonFilmInfoController.class);
    @Autowired
    FilmInfoService filmInfoService;
    /*
    访问地址如下:
    http://localhost:8090/film/json/film/showFilms/2
     */
    @RequestMapping("/showFilms/{currPage}")
    public Page<FilmInfoEntity> showFilms(Model model, @PathVariable Integer currPage)throws Exception{
        //注意  使用分页插件的时候   当前页码是1   需要Pageable需要-1
        //size   是每页显示条目数
        Pageable pageable = PageRequest.of(currPage-1,2);
        Page<FilmInfoEntity> pages = filmInfoService.findAll(pageable);
        return pages;
    }

    /*
        Mapper中  根据电影编号查电影
        http://localhost:8090/film/json/film/showFilm/1
     */
    @GetMapping("/showFilm/{filmName}")
    public List<FilmInfoEntity> showFilm(@PathVariable String filmName)throws Exception{
        System.out.println(filmName);
        List <FilmInfoEntity> filmInfoEntity = filmInfoService.findFilmByFilmName(filmName);
        return filmInfoEntity;
    }
    /*
        JPA中  根据电影编号查电影
        http://localhost:8090/film/json/film/showFilm2/1
     */
    @GetMapping("/showFilm2/{filmId}")
    public FilmInfoEntity showFilm2(@PathVariable Integer filmId)throws Exception{
        FilmInfoEntity filmInfoEntity = filmInfoService.findFilmByFilmId2(filmId);
        return filmInfoEntity;
    }
    /**
     * 电影删除
     * http://localhost:8090/film/json/film/delFilm/7
     */
    @GetMapping("/delFilm/{filmId}")
    public String delFilm(@PathVariable Integer filmId)throws Exception{
        System.out.println("获取到的电影编号:"+filmId);
        //调用删除方法
        boolean result = filmInfoService.delFilm(filmId);
        if(result){
            return "success";
        }
        return  "fail";
    }
    /*
    电影增加

     */
    @PostMapping("/addFilm")
    public String addFilm(@RequestBody FilmInfoEntity filmInfoEntity)throws Exception{
        System.out.println("vue发送的数据"+filmInfoEntity.toString());
        boolean result = filmInfoService.addFilm(filmInfoEntity);
        if(result){
            return "success";
        }
        return  "fail";
    }

    /*
    实现 文件上传功能
     */

    /**
     * 实现 文件上传功能
     * http://localhost:8090/film/json/film/uploadFilmImageMain1/1
     * 上传   电影编号是1 的  对应图片
     */
//    @RequestMapping("/uploadFilmImageMain1/{filmId}")
//    public String uploadFilmImageMain1(MultipartFile file,@PathVariable Integer filmId)
//            throws Exception{
//        if(file.isEmpty()){
//            return "fileEmpty";
//        }
//        String fileName = file.getOriginalFilename();
//        logger.info("上传文件名:"+fileName);
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        logger.info("上传后缀:"+suffixName);
//        String prefixName = fileName.substring(0,fileName.indexOf("."));
//        logger.info("上传前缀:"+prefixName);
//        //文件上传地址    将图片地址  拼接
//        //文件同名怎么办？  使用UUID 改造  文件
//        String newFileName = UUID.randomUUID()+suffixName;
//        System.out.println("重构后的文件名："+newFileName);
//        String imagePath = "F:\\upload_2020\\film\\"+filmId+"\\image\\"+newFileName;
//        logger.info("图片地址:"+imagePath);
//        File dest = new File(imagePath);
//        //判断上级文件是否存在
//        if(!dest.getParentFile().exists()){
//            dest.getParentFile().mkdirs();
//        }
//        //上传文件
//        try{
//            file.transferTo(dest);
//        }catch (IOException e){
//            e.printStackTrace();
//            return "error";
//        }
//        return "success";
//    }

    /**
     * 使用DTO  作为数据传输载体，携带数据
     */
    @RequestMapping("/uploadFilmImageMain2/{filmId}")
    public ResultDTO<FilmInfoEntity> uploadFilmImageMain2(MultipartFile file, @PathVariable Integer filmId)
            throws Exception{
        //调用Service中  上传方法
        ResultDTO<FilmInfoEntity> filmDTO= filmInfoService.uploadResult(file,filmId);

        return filmDTO;
    }

    @PostMapping("/updateFilm")
    public String updateFilm(@RequestBody FilmInfoEntity filmInfoEntity)throws Exception{
        System.out.println("vue发送的数据"+filmInfoEntity.getFilmVideo());
        boolean result = filmInfoService.updateFilm(filmInfoEntity);
        if(result){
            return "success";
        }
        return  "fail";
    }
    @RequestMapping("/uploadFilmVedio/{filmId}")
    public ResultDTO<FilmInfoEntity> uploadFilmVedio(MultipartFile file, @PathVariable Integer filmId)throws Exception{
        System.out.println(filmId);
        ResultDTO<FilmInfoEntity> filmDTO= filmInfoService.uploadVedioResult(file,filmId);
        return filmDTO;
    }

    @RequestMapping("/uploadFilmVedio1/{filmId}")
    public String  uploadFilmVedio1(MultipartFile file, @PathVariable Integer filmId)throws Exception{
        System.out.println(filmId);

        return "success";
    }
}
