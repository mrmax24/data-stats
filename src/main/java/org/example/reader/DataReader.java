package org.example.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    public List<Integer> readNumbersFromFile(String fileName) {
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            return lines.map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read results from file: " + fileName, e);
        }
    }
}
