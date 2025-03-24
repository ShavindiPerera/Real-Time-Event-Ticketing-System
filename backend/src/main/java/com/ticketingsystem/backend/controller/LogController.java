package com.ticketingsystem.backend.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final Path logFilePath = Paths.get("logs/simulation.log");

    @GetMapping
    public ResponseEntity<Resource> getLogs() {
        try {
            Resource resource = new UrlResource(logFilePath.toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=simulation.log")
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(resource);
        } catch (MalformedURLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
