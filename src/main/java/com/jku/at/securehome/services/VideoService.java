package com.jku.at.securehome.services;

import com.jku.at.securehome.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    Video getVideo(String name);

    void saveVideo(MultipartFile file, String name, String room) throws IOException;

    List<String> getAllVideoNames();

    List<String> getAllVideoNamesByRoom(String room);
}
