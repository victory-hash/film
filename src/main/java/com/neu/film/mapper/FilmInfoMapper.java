package com.neu.film.mapper;

import com.neu.film.pojo.FilmInfoEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FilmInfoMapper {

    @Select("SELECT FILM_ID filmId,FILM_NAME filmName,FILM_RELEASE_TIME filmReleaseTime," +
            "FILM_IMAGE_MAIN filmImageMain,FILM_IMAGE_OTHER filmImageOther,FILM_VIDEO filmVideo," +
            "FILM_VIDEO_URL filmVideoUrl,FILM_DIRECOTR filmDirecotr,FILM_PERFORMER filmPerformer" +
            " FROM film_info WHERE FILM_NAME like '%${value}%'")
    List<FilmInfoEntity> findFilmByName(String value);
    //根据电影编号 删除电影
    @Delete("DELETE FROM film_info where film_id=#{filmId}")
    int delFilmByFilmId(Integer filmId);
    //添加电影方法
    @Insert("INSERT INTO film_info(FILM_NAME,FILM_RELEASE_TIME ,FILM_IMAGE_MAIN,FILM_VIDEO,FILM_VIDEO_URL,FILM_DIRECOTR,FILM_PERFORMER)" +
            "VALUES (#{filmName},#{filmReleaseTime},#{filmImageMain},#{filmVideo},#{filmVideoUrl},#{filmDirecotr},#{filmPerformer})")
     int addFilm(FilmInfoEntity filmInfoEnity);

    @Update("UPDATE film_info SET FILM_NAME=#{filmName},FILM_RELEASE_TIME=#{filmReleaseTime}," +
            " FILM_IMAGE_MAIN=#{filmImageMain},FILM_VIDEO=#{filmVideo},FILM_VIDEO_URL=#{filmVideoUrl},FILM_DIRECOTR=#{filmDirecotr}," +
            "FILM_PERFORMER=#{filmPerformer} WHERE FILM_ID=#{filmId}")
    int updateFilm(FilmInfoEntity filmInfoEntity);



}
