package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.service.TrackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
public class TrackController {
    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @ApiOperation(value = "Saves track in database")
    @RequestMapping(value = "/track", method = RequestMethod.POST)
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @ApiOperation(value = "Gets all tracks from database")
    @RequestMapping(value = "/tracks", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> getAllTracks() {
        return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update comment of a track")
    @PutMapping(value = "/track/update/{id}/{comment}")
    public ResponseEntity<?> updateTrack(@PathVariable int id, @PathVariable String comment) {
        ResponseEntity responseEntity;
        try {
            trackService.updateTrack(id, comment);
            responseEntity = new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @ApiOperation(value = "Deletes a track from database")
    @DeleteMapping(value = "/track/delete/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable Integer id) {
        ResponseEntity responseEntity;
        try{
            trackService.deleteTrack(id);
            responseEntity = new ResponseEntity("Deleted Successfully", HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    /* Delete given  resource  */
    @ApiOperation(value = "Finds all the tracks with given name")
    @DeleteMapping("/track")
    public ResponseEntity<?> deleteUser() {
        ResponseEntity responseEntity;
        try {
            trackService.deleteAllTracks();
            responseEntity = new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
            return responseEntity;
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @ApiOperation(value = "Finds all the tracks with given name")
    @GetMapping("track/find/{trackName}")
    public ResponseEntity<?> getTrackByName( @PathVariable String trackName) {
        try {
            return new ResponseEntity<List<Track>>(trackService.getTrackByName(trackName), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
