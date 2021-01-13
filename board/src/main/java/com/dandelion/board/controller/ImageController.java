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
    public String fileupload(@RequestParam("file") MultipartFile[] multipartFile) {


//        System.out.println(multipartFile.length);
        List<Board> boardList = boardService.boardList();
        int lastNumber = boardList.stream()
                .sorted(Comparator.comparing(Board::getNumber).reversed())
                .findFirst()
                .get()
                .getNumber();
        Board board = boardService.findBoard(lastNumber);

        Path dir = Paths.get("c:/images/");

        for (MultipartFile file : multipartFile) {

            imageService.write(file, dir);

            Image image = new Image();

            image.setFileName(file.getOriginalFilename());
            image.setSize( (int) file.getSize());
            image.setImageDirNumber(dir.toString());
            image.setBoard(board);

            imageService.save(image);
        }

//        //이미지 파일을 받아서 dir 경로에 저장
//        Path dir = Paths.get("c:/images/");
//        imageService.write(multipartFile, dir);
//
//        //이미지 경로 및 내용 db에 저장
//        Image image = new Image();
//
//        image.setFileName(multipartFile.getOriginalFilename());
//        image.setSize( (int) multipartFile.getSize());
//        image.setImageDirNumber(dir.toString());
//

//
//        image.setBoard(board);
//        imageService.save(image);
//
        return String.format("file upload successfully"); //multipartFile.getOriginalFilename());
    }
}
