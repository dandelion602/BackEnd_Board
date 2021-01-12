package com.dandelion.board.controller;

import com.dandelion.board.service.BoardService;
import com.dandelion.board.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "*")
@RestController
public class ImageController {

    @Autowired
    BoardService boardService;

    @Autowired
    ImageService imageService;

    @PostMapping("/fileupload")
    public String fileupload(@RequestParam("file") MultipartFile multipartFile) {
        System.out.println(multipartFile.getName());
        System.out.println(multipartFile.getContentType());
        System.out.println(multipartFile.getSize());
        System.out.println(multipartFile.getClass());
        Path dir = Paths.get("c:/images/");
        imageService.write(multipartFile, dir);

        return String.format("file %s upload successfully", multipartFile.getOriginalFilename());
    }


}
