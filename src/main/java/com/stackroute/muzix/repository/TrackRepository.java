package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrackRepository extends MongoRepository<Track, Integer> {
    @Query("{'trackName' : ?0}")
    public List<Track> findByName(String trackName);
}
