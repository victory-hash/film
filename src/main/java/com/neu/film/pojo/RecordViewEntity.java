package com.neu.film.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "record_view", schema = "film", catalog = "")
public class RecordViewEntity {
    private int rId;
    private Integer uId;
    private Integer filmId;
    private Timestamp rTime;
    private String filmName;
    private String filmVideoUrl;
    private String uName;

    @Id
    @Column(name = "R_ID")
    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    @Basic
    @Column(name = "U_ID")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "FILM_ID")
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "R_TIME")
    public Timestamp getrTime() {
        return rTime;
    }

    public void setrTime(Timestamp rTime) {
        this.rTime = rTime;
    }

    @Basic
    @Column(name = "FILM_NAME")
    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @Basic
    @Column(name = "FILM_VIDEO_URL")
    public String getFilmVideoUrl() {
        return filmVideoUrl;
    }

    public void setFilmVideoUrl(String filmVideoUrl) {
        this.filmVideoUrl = filmVideoUrl;
    }

    @Basic
    @Column(name = "U_NAME")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordViewEntity that = (RecordViewEntity) o;
        return rId == that.rId &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(filmId, that.filmId) &&
                Objects.equals(rTime, that.rTime) &&
                Objects.equals(filmName, that.filmName) &&
                Objects.equals(filmVideoUrl, that.filmVideoUrl) &&
                Objects.equals(uName, that.uName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rId, uId, filmId, rTime, filmName, filmVideoUrl, uName);
    }
}
