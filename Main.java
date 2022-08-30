package java_core_3_1;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> dirList = Arrays.asList(
                new File("C://Games"),
                new File("C://Games//src"),
                new File("C://Games//res"),
                new File("C://Games//savesgames"),
                new File("C://Games//temp"),
                new File("C://Games//src//main"),
                new File("C://Games//src//test"),
                new File("C://Games//res//drawables"),
                new File("C://Games//res//vectors"),
                new File("C://Games//res//icons")
        );

        List<File> fileList = Arrays.asList(
                new File("C://Games//src//main//Main.java"),
                new File("C://Games//src//main//Utils.java"),
                new File("C://Games//temp//temp.txt")
        );

        dirList.stream().forEach(dir -> {
            if (dir.mkdir()) {
                sb.append("Каталог " + dir + " создан\n");
            } else {
                sb.append("Каталог " + dir + "не создан\n");
            }
        });

        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) {
                    sb.append("Файл " + file + " создан\n");
                } else {
                    sb.append("Файл " + file + " не создан\n");
                }
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });

        try (FileWriter writer = new FileWriter("C://Games//temp//temp.txt", false)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
    }
}

