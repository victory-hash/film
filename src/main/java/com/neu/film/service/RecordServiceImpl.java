package com.neu.film.service;

import com.neu.film.mapper.RecordMapper;
import com.neu.film.pojo.RecordEntity;
import com.neu.film.pojo.RecordViewEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/RecordService")
public class RecordServiceImpl implements RecordService {
    @Resource
    RecordMapper recordMapper;


    @Override
    public List<RecordViewEntity>  findRecordByName(String uName) throws Exception {
        return recordMapper.findRecordByName(uName);
    }

    @Override
    public boolean insertRecord(RecordEntity recordEntity) throws Exception {
        int result= recordMapper.insertRecord(recordEntity);
        if(result>0) return true;
        return false;
    }

    @Override
    public boolean deleteRecord(int rId) throws Exception {
        int result = recordMapper.deleteRecord(rId);
        if(result>0){
            return true;
        }
        return false;
    }


}
