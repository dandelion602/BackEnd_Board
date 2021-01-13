package com.dandelion.board.controller;

import com.dandelion.board.entity.Board;
import com.dandelion.board.entity.Image;
import com.dandelion.board.service.BoardService;
import com.dandelion.board.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "*")
@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    BoardService boardService;


    @PostMapping("/fileupload/")
    public String fileupload(@RequestParam("file") MultipartFile multipartFile) {

        //이미지 파일을 받아서 dir 경로에 저장
        Path dir = Paths.get("c:/images/");
        imageService.write(multipartFile, dir);

        //이미지 경로 및 내용 db에 저장
        Image image = new Image();

        image.setFileName(multipartFile.getOriginalFilename());
        image.setSize( (int) multipartFile.getSize());
        image.setImageDirNumber(dir.toString());


        imageService.save(image);

        return String.format("file %s upload successfully", multipartFile.getOriginalFilename());
    }
}
