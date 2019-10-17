package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
//import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();
    public Track updateTrack(int id, String comment) throws TrackNotFoundException;
    public boolean deleteTrack(int id);
    public boolean deleteAllTracks();
    public List<Track> getTrackByName(String trackName);
}
