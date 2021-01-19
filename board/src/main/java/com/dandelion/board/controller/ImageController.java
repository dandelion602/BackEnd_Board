package com.dandelion.board.controller;

import com.dandelion.board.entity.Board;
import com.dandelion.board.entity.ItemImage;
import com.dandelion.board.service.BoardService;
import com.dandelion.board.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.nio.file.Path;


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

//        Path dir = Paths.get("C:\\javian\\dandelion\\BackEnd_Board\\vue\\dandelion 2\\src\\assets\\images\\");
        Path dir = imageService.getAbsolutePath("../vue/dandelion 2/src/assets/images/");

        Board board = boardService.findLastBoard();

        for (MultipartFile file : multipartFile) {

            imageService.write(file, dir.toAbsolutePath(), board.getNumber() + "_" + (order));
            ItemImage itemImage = new ItemImage();
            // 나중에 이미지서비스에 메서드로 옮기기... 아니면 생성자라도 만드러엇 단순화시키기
            itemImage.setFileName(board.getNumber() + "_" + (order));
            itemImage.setSize( (int) file.getSize());
            itemImage.setImageDir(dir.toString());
            itemImage.setFileOriName(file.getOriginalFilename());
            itemImage.setFormat(imageService.getFormat(file));
            itemImage.setOrderNumber(order);
            itemImage.setBoardNumber(board.getNumber());
            imageService.save(itemImage);

            order++;
        }

        return String.format("file upload successfully");
    }
}
