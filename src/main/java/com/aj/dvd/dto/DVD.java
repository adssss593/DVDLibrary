package com.aj.dvd.dto;

import java.util.Objects;

public class DVD {

    private String title,releaseDate,mPPARating,director,studio,userNote;

    public DVD(String title) {
        this.title = title;
    }

    public DVD(String title, String releaseDate, String mPPARating, String director, String studio, String userNote) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.mPPARating = mPPARating;
        this.director = director;
        this.studio = studio;
        this.userNote = userNote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseData(String releaseData) {
        this.releaseDate = releaseData;
    }

    public String getmPPARating() {
        return mPPARating;
    }

    public void setmPPARating(String mPPARating) {
        this.mPPARating = mPPARating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    @Override
    public String toString(){
        return "Title: " + this.title +
                "\nRelease date: " + this.releaseDate +
                "\nMPPA rating: " + this.mPPARating +
                "\nDirector: " + this.director +
                "\nStudio: " + this.studio +
                "\nFurther remarks: " + this.userNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return Objects.equals(getTitle(), dvd.getTitle()) && Objects.equals(getReleaseDate(), dvd.getReleaseDate()) && Objects.equals(getmPPARating(), dvd.getmPPARating()) && Objects.equals(getDirector(), dvd.getDirector()) && Objects.equals(getStudio(), dvd.getStudio()) && Objects.equals(getUserNote(), dvd.getUserNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getReleaseDate(), getmPPARating(), getDirector(), getStudio(), getUserNote());
    }
}
