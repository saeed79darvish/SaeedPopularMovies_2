package com.example.saeed.saeedpopularmovies_2.Models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.io.Serializable;

@Parcel
public class Movie implements Serializable {
    @SerializedName("poster_path")
    public String poster_path;
    @SerializedName("overview")
    public String overview;
    @SerializedName("release_date")
    public String release_date;
    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("vote_average")
    public String vote_average;


    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "poster_path='" + poster_path + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", vote_average='" + vote_average + '\'' +
                '}';
    }
}