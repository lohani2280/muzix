package com.stackroute.muzix.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Track {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackID;
    private String trackName;
    private String comments;

    public Track(int trackID, String trackName, String comments) {
        this.trackID = trackID;
        this.trackName = trackName;
        this.comments = comments;
    }

    public Track() {
    }

    public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    @Override
    public String toString() {
        return "Track{" +
                "trackID=" + trackID +
                ", trackName='" + trackName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
