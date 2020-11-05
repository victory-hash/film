package com.neu.film.mapper;

import com.neu.film.pojo.FilmInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//掌握 JPA 使用
public interface FilmInfoEntityRepository extends JpaRepository<FilmInfoEntity,Long> {
    //JPA 分页查询
    Page<FilmInfoEntity> findAll(Pageable pageable);


    //根据电影编号查电影
    FilmInfoEntity findByFilmId(int fimId);
}
