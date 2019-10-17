package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("notdummy")

public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackID())) {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track trackOne = trackRepository.save(track);
        if (trackOne == null) {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return trackOne;
    }

    @Override
    public List<Track> getAllTracks() {
        System.out.println("hey i am back in TrackServiceImp");
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(int id, String comment) throws TrackNotFoundException {
        if (trackRepository.existsById(id)){
            Track trackOne = trackRepository.findById(id).get();
            trackOne.setComments(comment);
            trackRepository.save(trackOne);
            return trackOne;
        }
        else {
            throw new TrackNotFoundException("Track not found exception");
        }
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

    @Override
    public List<Track> getTrackByName(String trackName)
    {
        List<Track>list=trackRepository.findByName(trackName);
        return list;
    }


}
