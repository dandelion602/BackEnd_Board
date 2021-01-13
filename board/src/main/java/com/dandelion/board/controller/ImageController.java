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
import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ImageController {

    @Autowired
    ImageService imageService;
    @Autowired
    BoardService boardService;

    @PostMapping("/fileupload/")
    public String fileupload(@RequestParam("files") MultipartFile[] multipartFile) {

        int order = 0;
        Path dir = Paths.get("c:/images/");
        Board board = boardService.findLastBoard();

        for (MultipartFile file : multipartFile) {

            imageService.write(file, dir, board.getNumber() + "_" + order++);
            Image image = new Image();
            // 나중에 이미지서비스에 메서드로 옮기기...
            image.setFileName(file.getOriginalFilename());
            image.setSize( (int) file.getSize());
            image.setImageDirNumber(dir.toString());

            image.setBoard(board);
            imageService.save(image);
        }

        System.out.println(boardService.findLastBoard());
        return String.format("file upload successfully"); //multipartFile.getOriginalFilename());
    }
}
