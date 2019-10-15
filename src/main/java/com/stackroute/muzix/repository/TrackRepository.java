package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Integer> {
}
