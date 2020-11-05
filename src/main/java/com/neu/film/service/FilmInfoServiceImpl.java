package com.neu.film.service;

import com.neu.film.mapper.FilmInfoEntityRepository;
import com.neu.film.mapper.FilmInfoMapper;
import com.neu.film.pojo.FilmInfoEntity;
import com.neu.film.pojo.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("/filmInfoService")
public class FilmInfoServiceImpl implements FilmInfoService{

    private static final Logger logger = LoggerFactory.getLogger(FilmInfoServiceImpl.class);
    @Resource
    FilmInfoEntityRepository filmInfoEntityRepository;
    @Resource
    FilmInfoMapper filmInfoMapper;

    @Override
    public Page<FilmInfoEntity> findAll(Pageable pageable) {
        return filmInfoEntityRepository.findAll(pageable);
    }

    @Override
    public List<FilmInfoEntity> findFilmByFilmName(String filmName) {
        return filmInfoMapper.findFilmByName(filmName);
    }

    @Override
    public FilmInfoEntity findFilmByFilmId2(int filmId) {
        return filmInfoEntityRepository.findByFilmId(filmId);
    }
    /*
    删除电影   业务逻辑
     */
    @Override
    public boolean delFilm(Integer filmId) {
        int i = filmInfoMapper.delFilmByFilmId(filmId);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addFilm(FilmInfoEntity filmInfoEntity) {
        int i = filmInfoMapper.addFilm(filmInfoEntity);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateFilm(FilmInfoEntity filmInfoEntity) {
        int i = filmInfoMapper.updateFilm(filmInfoEntity);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public ResultDTO<FilmInfoEntity> uploadResult(MultipartFile file, Integer filmId) throws Exception {
        ResultDTO<FilmInfoEntity> uploadResult = new ResultDTO<FilmInfoEntity>();
        if(file.isEmpty()){
            //处理文件未得到的DTO
            uploadResult.setCode(1001);
            uploadResult.setMsg("上传文件为空");
        }else{
            String fileName = file.getOriginalFilename();
            logger.info("上传文件名:"+fileName);
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            logger.info("上传后缀:"+suffixName);
            String prefixName = fileName.substring(0,fileName.indexOf("."));
            logger.info("上传前缀:"+prefixName);
            //文件上传地址    将图片地址  拼接
            //文件同名怎么办？  使用UUID 改造  文件
            String newFileName = UUID.randomUUID()+suffixName;
            System.out.println("重构后的文件名："+newFileName);
            String imagePath = "F:\\upload_2020\\film\\"+filmId+"\\image\\"+newFileName;
            logger.info("图片地址:"+imagePath);
            File dest = new File(imagePath);
            //判断上级文件是否存在
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            //上传文件
            try{
                file.transferTo(dest);
            }catch (IOException e){
                e.printStackTrace();
                //处理报错DTO
                uploadResult.setCode(1002);
                uploadResult.setMsg("上传文件失败");
            }
            //处理 成功的DTO
            uploadResult.setCode(8888);
            uploadResult.setMsg("上传文件成功");
            FilmInfoEntity filmInfoEntity = new FilmInfoEntity();
            String imgUrl = "http://localhost:8090/film/resources/"
                    +filmId+"/image/"+newFileName;
            System.out.println("图片在服务器的地址:"+imgUrl);
            filmInfoEntity.setFilmImageMain(imgUrl);
            List<FilmInfoEntity> datas = new ArrayList<FilmInfoEntity>();
            datas.add(filmInfoEntity);
            uploadResult.setData(datas);
        }
        return uploadResult;
    }

    @Override
    public ResultDTO<FilmInfoEntity> uploadVedioResult(MultipartFile file,Integer filmId) throws Exception {
        ResultDTO<FilmInfoEntity> uploadResult = new ResultDTO<FilmInfoEntity>();
        if(file.isEmpty()){
            //处理文件未得到的DTO
            uploadResult.setCode(1001);
            uploadResult.setMsg("上传文件为空");
        }else{
            String fileName = file.getOriginalFilename();
            logger.info("上传文件名:"+fileName);
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            logger.info("上传后缀:"+suffixName);
            String prefixName = fileName.substring(0,fileName.indexOf("."));
            logger.info("上传前缀:"+prefixName);
            //文件上传地址    将图片地址  拼接
            //文件同名怎么办？  使用UUID 改造  文件
            String newFileName = UUID.randomUUID()+suffixName;
            System.out.println("重构后的文件名："+newFileName);
            String VedioPath = "F:\\upload_2020\\film\\"+filmId+"\\video\\"+newFileName;
            logger.info("视频地址:"+VedioPath);
            File dest = new File(VedioPath);
            //判断上级文件是否存在
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            //上传文件
            try{
                file.transferTo(dest);
            }catch (IOException e){
                e.printStackTrace();
                uploadResult.setCode(1002);
                uploadResult.setMsg("上传文件失败");
            }
            //处理 成功的DTO
            uploadResult.setCode(8888);
            uploadResult.setMsg("上传文件成功");
            FilmInfoEntity filmInfoEntity = new FilmInfoEntity();
            String VedioUrl = "http://localhost:8090/film/resources/"
                    +filmId+"/video/"+newFileName;
            System.out.println("图片在服务器的地址:"+VedioUrl);
            filmInfoEntity.setFilmVideoUrl(VedioUrl);
            filmInfoEntity.setFilmVideo(fileName);
            List<FilmInfoEntity> datas = new ArrayList<FilmInfoEntity>();
            datas.add(filmInfoEntity);
            uploadResult.setData(datas);
        }
        return uploadResult;
    }
}
