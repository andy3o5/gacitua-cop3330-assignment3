package Exercise45;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Andres Gacitua
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordFinder
{
    private String originalFile = "";
    private String newFile = "";

    public void readFile(String filename) throws IOException
    {
        Path file = Paths.get(filename);
        originalFile = new String(Files.readAllBytes(file));
        if (originalFile.isEmpty())
        {
            throw new IllegalArgumentException("File is empty.");
        }
    }

    public void replace(String oldWord, String newWord)
    {
        newFile = originalFile.replace(oldWord, newWord);
    }

    public String writeFile() throws IOException
    {
        Path newFilePath = Paths.get("src/ex45wordFinder/new-text.txt");
        Files.write(newFilePath, newFile.getBytes());
        return newFile;
    }
}