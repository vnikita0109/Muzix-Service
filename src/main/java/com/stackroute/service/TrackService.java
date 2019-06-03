package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;


import java.util.List;

public interface TrackService {
    public Track createTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();
    public Track findTrack(Track track) throws TrackNotFoundException;
    public String deleteTrack(Track track) throws TrackNotFoundException;
    public Track updateTrack(Track track) throws TrackNotFoundException;
    public Track searchTrack(Track track) throws TrackNotFoundException;
}
