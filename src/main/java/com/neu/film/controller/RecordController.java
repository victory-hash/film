package com.neu.film.controller;

import com.neu.film.pojo.RecordEntity;
import com.neu.film.pojo.RecordViewEntity;
import com.neu.film.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @RequestMapping("/findRecordByName/{uName}")
     List<RecordViewEntity> findHistoryByName(@PathVariable String uName) throws Exception{
        return recordService.findRecordByName(uName);
    }

    @PostMapping("/addRecord")
    String addRecord(@RequestBody RecordEntity recordEntity) throws Exception{
        boolean result = recordService.insertRecord(recordEntity);
        if(result) {
            return "success";
        }
        return "fail";
    }

    @GetMapping("/deleteRecord/{rId}")
    String deleteRecord(@PathVariable Integer rId)throws Exception {
        boolean result = recordService.deleteRecord(rId);
        if (result) {
            return "success";
        }
        return "false";
    }

}
