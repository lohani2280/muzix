package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.service.TrackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PropertySources({
        @PropertySource(value = "classpath:application-mongo.properties"),
        // @PropertySource(value = "classpath:application.properties")
})
@RestController
@RequestMapping(value="/api/v1")
public class TrackController {
    @Autowired
    TrackService trackService;

    public TrackController( TrackService trackService) {
        this.trackService = trackService;
    }

    @ApiOperation(value = "Saves track in database")
    @RequestMapping(value = "/track", method = RequestMethod.POST)
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException{
        trackService.saveTrack(track);
        ResponseEntity responseEntity = new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation(value = "Gets all tracks from database")
    @RequestMapping(value = "/tracks", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> getAllTracks() {
        return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update comment of a track")
    @PutMapping(value = "/track/update/{id}/{comment}")
    public ResponseEntity<?> updateTrack(@PathVariable int id, @PathVariable String comment) throws TrackNotFoundException{
        trackService.updateTrack(id, comment);
        ResponseEntity responseEntity = new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation(value = "Deletes a track from database")
    @DeleteMapping(value = "/track/delete/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable Integer id) throws Exception{
        trackService.deleteTrack(id);
        ResponseEntity responseEntity = new ResponseEntity("Deleted Successfully", HttpStatus.OK);
        return responseEntity;
    }

    /* Delete given  resource  */
    @ApiOperation(value = "Finds all the tracks with given name")
    @DeleteMapping("/track")
    public ResponseEntity<?> deleteUser() throws Exception{
        trackService.deleteAllTracks();
        ResponseEntity responseEntity = new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
        return responseEntity;

    }

    @ApiOperation(value = "Finds all the tracks with given name")
    @GetMapping("track/find/{trackName}")
    public ResponseEntity<?> getTrackByName( @PathVariable String trackName) throws Exception{
        return new ResponseEntity<List<Track>>(trackService.getTrackByName(trackName), HttpStatus.OK);

    }
}
