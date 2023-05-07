package com.jku.at.securehome.controller;

import com.jku.at.securehome.services.VideoStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController()
@RequestMapping("/upload")
public class VideoUploadController {
    private final VideoStorageService fileStorageService;

    public VideoUploadController(VideoStorageService videoStorageService) {
        this.fileStorageService = videoStorageService;
    }

    @PostMapping("/")
    public ResponseEntity<String> uploadFile(
            @RequestParam(name = "file", required = false) MultipartFile file
    ) {

        String fileName = fileStorageService.storeFile(file);

        return ResponseEntity.ok().body(fileName);
    }
}
