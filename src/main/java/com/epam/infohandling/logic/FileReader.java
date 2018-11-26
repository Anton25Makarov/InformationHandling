package com.epam.infohandling.logic;

import com.epam.infohandling.exception.ReadFileException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileReader {
    public String readFile(String filePath) throws ReadFileException {
        byte[] text;
        try {
            text = Files.readAllBytes(Paths.get(filePath));
        } catch (NoSuchFileException e) {
            throw new ReadFileException("Can not read file", e);
        } catch (IOException e) {
            throw new ReadFileException("I/O Exception", e);
        }
        return new String(text, StandardCharsets.UTF_8);
    }
}
