package ru.job4j.io;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
               zip.putNextEntry(new ZipEntry(source.toString()));
               try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                   zip.write(out.readAllBytes());
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
 /*     Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );   */
        if (Search.validation(args)) {
            ArgsName argsName = ArgsName.of(args);
            Path dir = Path.of(argsName.get("d"));
            String ex = argsName.get("e");
            List<Path> list = Search.search(dir, p -> !p.toFile().getName().endsWith(ex));
            File output = new File(argsName.get("о"));
            packFiles(list, output);
        }
    }
}
