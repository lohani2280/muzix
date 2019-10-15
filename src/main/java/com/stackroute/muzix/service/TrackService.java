package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track);
    public List<Track> getAllTracks();
    public Track updateTrack(int id, String comment);
    public boolean deleteTrack(int id);
    public boolean deleteAllTracks();
}
