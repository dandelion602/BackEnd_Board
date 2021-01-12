package com.dandelion.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.ServletContext;
import java.io.File;

@SpringBootTest
class BoardApplicationTests {

    @Autowired
    public ServletContext context;

    @Test
    void contextLoads() {

        String absolutePath = context.getRealPath("resources/board_images");
//        File uploadedFile = new File(absolutePath, "your_file_name");

        System.out.println(absolutePath);
    }

}
