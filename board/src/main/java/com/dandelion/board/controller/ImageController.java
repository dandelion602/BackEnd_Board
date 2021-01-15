package com.dandelion.board.controller;

import com.dandelion.board.entity.Board;
import com.dandelion.board.entity.Image;
import com.dandelion.board.service.BoardService;
import com.dandelion.board.service.ImageService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
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
        Path dir = Paths.get("C:\\Users\\M\\Desktop\\projcet\\vue\\dandelion_project\\Front_End\\dandelion 2\\src\\assets\\images\\");
        Board board = boardService.findLastBoard();

        for (MultipartFile file : multipartFile) {

            imageService.write(file, dir, board.getNumber() + "_" + (order));
            Image image = new Image();
            // 나중에 이미지서비스에 메서드로 옮기기...
            image.setFileName(board.getNumber() + "_" + (order));
            image.setSize( (int) file.getSize());
            image.setImageDir(dir.toString());
            image.setFileOriName(file.getOriginalFilename());
            image.setFormat(imageService.getFormat(file));
            image.setOrderNumber(order);

            image.setBoardNumber(board.getNumber());
            imageService.save(image);
            order++;
        }

        return String.format("file upload successfully"); //multipartFile.getOriginalFilename());
    }
}
