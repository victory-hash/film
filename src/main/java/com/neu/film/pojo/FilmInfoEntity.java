package com.neu.film.pojo;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "film_info", schema = "film", catalog = "")
public class FilmInfoEntity {
    private int filmId;
    private String filmName;
    private Timestamp filmReleaseTime;
    private String filmImageMain;
    private String filmImageOther;
    private String filmVideo;
    private String filmVideoUrl;
    private String filmDirecotr;
    private String filmPerformer;

    @Id
    @Column(name = "FILM_ID")
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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
    @Column(name = "FILM_RELEASE_TIME")
    public Timestamp getFilmReleaseTime() {
        return filmReleaseTime;
    }

    public void setFilmReleaseTime(Timestamp filmReleaseTime) {
        this.filmReleaseTime = filmReleaseTime;
    }

    @Basic
    @Column(name = "FILM_IMAGE_MAIN")
    public String getFilmImageMain() {
        return filmImageMain;
    }

    public void setFilmImageMain(String filmImageMain) {
        this.filmImageMain = filmImageMain;
    }

    @Basic
    @Column(name = "FILM_IMAGE_OTHER")
    public String getFilmImageOther() {
        return filmImageOther;
    }

    public void setFilmImageOther(String filmImageOther) {
        this.filmImageOther = filmImageOther;
    }

    @Basic
    @Column(name = "FILM_VIDEO")
    public String getFilmVideo() {
        return filmVideo;
    }

    public void setFilmVideo(String filmVideo) {
        this.filmVideo = filmVideo;
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
    @Column(name = "FILM_DIRECOTR")
    public String getFilmDirecotr() {
        return filmDirecotr;
    }

    public void setFilmDirecotr(String filmDirecotr) {
        this.filmDirecotr = filmDirecotr;
    }

    @Basic
    @Column(name = "FILM_PERFORMER")
    public String getFilmPerformer() {
        return filmPerformer;
    }

    public void setFilmPerformer(String filmPerformer) {
        this.filmPerformer = filmPerformer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmInfoEntity that = (FilmInfoEntity) o;
        return filmId == that.filmId &&
                Objects.equals(filmName, that.filmName) &&
                Objects.equals(filmReleaseTime, that.filmReleaseTime) &&
                Objects.equals(filmImageMain, that.filmImageMain) &&
                Objects.equals(filmImageOther, that.filmImageOther) &&
                Objects.equals(filmVideo, that.filmVideo) &&
                Objects.equals(filmVideoUrl, that.filmVideoUrl) &&
                Objects.equals(filmDirecotr, that.filmDirecotr) &&
                Objects.equals(filmPerformer, that.filmPerformer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, filmName, filmReleaseTime, filmImageMain, filmImageOther, filmVideo, filmVideoUrl, filmDirecotr, filmPerformer);
    }
}
