package com.dandelion.board.service;

import com.dandelion.board.entity.Image;
import com.dandelion.board.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;


    public void write(MultipartFile file, Path dir, String newFileName) {

        String format = getFormat(file);
        Path filepath = Paths.get(dir.toString(), newFileName + format);

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFormat (MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        int dotPos = originalFileName.indexOf(".");
        String format = originalFileName.substring(dotPos, originalFileName.length());
        return format;
    }

    public Image save(Image image) {
        return imageRepository.save(image);
    }


}
