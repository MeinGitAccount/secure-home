package com.jku.at.securehome.controller;

import com.jku.at.securehome.model.Video;
import com.jku.at.securehome.services.VideoService;
import com.jku.at.securehome.services.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/video")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws IOException {
        videoService.saveVideo(file, name);
        return ResponseEntity.ok("Video saved.");
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllVideoNames() {
        return ResponseEntity.ok(videoService.getAllVideoNames());
    }

    @GetMapping("/video/{name}")
    public ResponseEntity<ByteArrayResource> getVideo(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(videoService.getVideo(name).getData()));
    }
}