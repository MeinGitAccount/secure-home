package com.jku.at.securehome.services;

import com.jku.at.securehome.exceptions.VideoAlreadyExistsException;
import com.jku.at.securehome.exceptions.VideoNotFoundException;
import com.jku.at.securehome.model.Video;
import com.jku.at.securehome.repos.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository repo;

    @Override
    public Video getVideo(String name) {
        if(!repo.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return repo.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repo.getAllEntryNames();
    }

    @Override
    public List<String> getAllVideoNamesByRoom(String room){
        return repo.getAllVideoNamesByRoom(room);
    }

    @Override
    public void saveVideo(MultipartFile file, String name, String room) throws IOException {
        if(repo.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        if(!name.endsWith(".mp4")) name = name + ".mp4";
        Video newVid = new Video(name, file.getBytes(), room);
        repo.save(newVid);
    }
}