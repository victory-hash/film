package com.neu.film.service;

import com.neu.film.pojo.RecordEntity;
import com.neu.film.pojo.RecordViewEntity;

import java.util.List;

public interface RecordService {

   List<RecordViewEntity>  findRecordByName(String uName) throws Exception;

   boolean insertRecord(RecordEntity recordEntity)throws Exception;

   boolean deleteRecord(int rId)throws Exception;

}
