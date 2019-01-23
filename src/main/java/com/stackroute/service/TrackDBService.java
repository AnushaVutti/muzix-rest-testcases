package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.MusicAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service
public class TrackDBService implements TrackService {
    @Autowired
    private MusicAlbum musicAlbum;
    public TrackDBService(MusicAlbum musicAlbum) {
        this.musicAlbum = musicAlbum;
    }

    public void setMusicAlbum(MusicAlbum musicAlbum) {
        this.musicAlbum = musicAlbum;
    }

    public Track saveTrack (Track track) throws TrackAlreadyExistsException {
        if(musicAlbum.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track track1 = musicAlbum.save(track);
        if(track1 == null) {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return track1;
    }
    public List<Track> getAllTracks() {
        List<Track> playList = (List<Track>) musicAlbum.findAll();
        return playList;
    }

    public void deleteTrack(int trackId)  throws TrackNotFoundException{
        if(musicAlbum.existsById(trackId))
            musicAlbum.deleteById(trackId);
        else {
            throw new TrackNotFoundException("Track not found");
        }

    }
    public Track updateTrack(int trackId, Track track)  throws TrackNotFoundException{
//        Track track1 = musicAlbum.findById(trackId).get();
        if(musicAlbum.existsById(trackId)) {
            Track track1 = musicAlbum.save(track);
            return track1;
        }
        else
            throw new TrackNotFoundException("Track not found");

    }
}
