package com.tomorrowman.sorter;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Eigenaar on 9-3-2016.
 */
public class SortMyFiles implements FileVisitor<Path> {
    private PathMatcher matcherRED;
    private PathMatcher matcherGREEN;
    private PathMatcher matcherBLUE;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        Path name = file.getFileName();
        Path path = Paths.get("C:\\Colours");
        Path RED = Paths.get("C:\\Colours\\RED");
        Path GREEN = Paths.get("C:\\Colours\\GREEN");
        Path BLUE = Paths.get("C:\\Colours\\BLUE");

        matcherRED = FileSystems.getDefault().getPathMatcher("glob:*RED*");
        matcherGREEN = FileSystems.getDefault().getPathMatcher("glob:*GREEN*");
        matcherBLUE = FileSystems.getDefault().getPathMatcher("glob:*BLUE*");

        if (name != null && matcherRED.matches(name)){
            System.out.format("Regular file: %s", file);
            try {
                Files.move(file, RED, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e);
            }
        }else if (name != null && matcherGREEN.matches(name)){
            System.out.format("Regular file: %s", file);
            try {
                Files.move(file, GREEN, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e);
            }
        }else if (name != null && matcherBLUE.matches(name)) {
            System.out.format("Regular file: %s", file);
            try {
                Files.move(file, BLUE, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        System.out.println("");

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
