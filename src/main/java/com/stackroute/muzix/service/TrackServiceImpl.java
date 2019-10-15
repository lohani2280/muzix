package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(int id, String comment) {
        Track trackOne = trackRepository.findById(id).get();
        trackOne.setComments(comment);
        trackRepository.save(trackOne);
        return trackOne;
    }

    @Override
    public boolean deleteTrack(int id){
        trackRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAllTracks(){
        trackRepository.deleteAll();
        return true;
    }
}
