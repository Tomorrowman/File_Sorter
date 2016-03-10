package com.tomorrowman.sorter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Eigenaar on 9-3-2016.
 */
public class FileSorter {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Colours");


        Files.walkFileTree(path, new SortMyFiles());
    }
}
