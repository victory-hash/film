package com.neu.film.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "record", schema = "film", catalog = "")
public class RecordEntity {
    private int rId;
    private Integer uId;
    private Integer filmId;
    private Timestamp rTime;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordEntity that = (RecordEntity) o;
        return rId == that.rId &&
                Objects.equals(uId, that.uId) &&
                Objects.equals(filmId, that.filmId) &&
                Objects.equals(rTime, that.rTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rId, uId, filmId, rTime);
    }
}
