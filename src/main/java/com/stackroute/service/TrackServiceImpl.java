package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class TrackServiceImpl implements TrackService {
    @Autowired
    TrackRepository trackRepository;
    String message=null;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }


    @Override
    public Track createTrack(Track track) throws TrackAlreadyExistsException {

        if (trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack= trackRepository.save(track);
        if (savedTrack==null){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return savedTrack;

    }
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track findTrack(Track track) throws TrackNotFoundException {

        Track foundTrack=null;
        if (trackRepository.existsById(track.getId())){
            foundTrack=trackRepository.getOne(track.getId());
        }

        if (foundTrack==null){
            throw new TrackNotFoundException("Track does not exist");
        }
        return foundTrack;
    }

    @Override
    public String deleteTrack(Track track) throws TrackNotFoundException {
        Track existedTrack=null;

        if (trackRepository.existsById(track.getId())){
            trackRepository.deleteById(track.getId());
        }
        else
        {
            throw new TrackNotFoundException("Track does not exist");
        }
        return message;
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        Track existingTrack=null;
        if (trackRepository.existsById(track.getId())){
            track.setComments(track.getComments());
            trackRepository.getOne(track.getId());
        }
        else
        {
            throw new TrackNotFoundException("Track does not exist");
        }
        return existingTrack;
    }
    @Override
    public Track searchTrack(Track track) throws TrackNotFoundException{
        Track foundTrack=null;

            foundTrack=trackRepository.trackByName(track.getTrackName());


        if (foundTrack==null){
            throw new TrackNotFoundException("Track does not exist");
        }
        return foundTrack;
    }

}
