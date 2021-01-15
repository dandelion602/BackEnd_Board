package com.dandelion.board.directory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
class DirTest {

    @Test
    void findDir() {
        File dir = new File("../vue/dandelion 2/src/assets/images/");
        System.out.println(dir.getAbsolutePath());
        Path path = Paths.get("../vue/dandelion 2/src/assets/images/");
        System.out.println(path.toAbsolutePath().normalize());
    }
}