package com.neu.film.mapper;

import com.neu.film.pojo.RecordEntity;
import com.neu.film.pojo.RecordViewEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecordMapper {
    //    @Select("SELECT R_ID rId,record.FILM_ID filmId,U_NAME uName,FILM_NAME filmName," +
//            "FILM_VIDEO_URL filmVideoUrl,R_TIME rTime " +
//            "FROM record,film_info,user " +
//            "where user.u_id=record.u_id and film_info.film_id=record.r_id and u_Name=#{uName}")
//    List<RecordViewEntity> findRecordByName(String uName) throws Exception;
    @Select("SELECT R_ID rId,U_NAME uName,FILM_ID filmId,FILM_NAME filmName,FILM_VIDEO_URL filmVideoUrl,R_TIME rTime FROM record_view where u_Name=#{uName} ")
    List<RecordViewEntity> findRecordByName(String uName) throws Exception;

    @Insert("INSERT INTO record(u_id,film_id,r_time) values(#{uId},#{filmId},now())")
    int insertRecord(RecordEntity recordEntity);

    @Delete("DELETE FROM record where R_ID=#{rId}")
    int deleteRecord(int rId);

}
