package com.neu.film.service;

import com.neu.film.pojo.FilmInfoEntity;
import com.neu.film.pojo.ResultDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FilmInfoService {
    //JPA分页查询电影
    Page<FilmInfoEntity> findAll(Pageable pageable);
    //Mapper根据电影名查询的电影
    List<FilmInfoEntity> findFilmByFilmName(String filmName);
    //JPA根据电影编号查询的电影
    FilmInfoEntity findFilmByFilmId2(int filmId);
    //删除电影
    boolean delFilm(Integer filmId);

    //增加电影信息
    boolean addFilm(FilmInfoEntity filmInfoEntity);

    //修改电影
    boolean updateFilm(FilmInfoEntity filmInfoEntity);

    //文件上传逻辑
    ResultDTO<FilmInfoEntity> uploadResult(MultipartFile file, Integer filmId)
            throws Exception;

    //文件上传逻辑
    ResultDTO<FilmInfoEntity> uploadVedioResult(MultipartFile file, Integer filmId)
            throws Exception;

}
