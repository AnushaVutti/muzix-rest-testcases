package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class MusicController {

    @Autowired
    private TrackService trackService;
//
//    public MusicController(TrackService trackService) {
//        this.trackService = trackService;
//    }
//    public void setTrackService(TrackService trackService) {
//        this.trackService = trackService;
//    }
    @RequestMapping(value = "track", method = RequestMethod.POST)
    public ResponseEntity<Track> saveTrack(@RequestBody Track track) {
        Track track1 = trackService.saveTrack(track);
        return new ResponseEntity<Track>(track1, HttpStatus.OK);
    }
    @RequestMapping(value = "tracks", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> listOfTracks() {
        List<Track> allTracks = trackService.getAllTracks();
        return new ResponseEntity<List<Track>>(allTracks, HttpStatus.OK);
    }
    @RequestMapping(value = "tracksafterdeletion", method = RequestMethod.DELETE)
    public ResponseEntity<List<Track>> deleteById(Integer trackId){
        List<Track> allTracks = trackService.getAllTracks();
        return new ResponseEntity<List<Track>>(allTracks, HttpStatus.OK);
    }

}
