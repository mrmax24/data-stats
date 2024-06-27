package app.service.impl;

import app.service.DataReader;
import app.service.NumberParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderImpl implements DataReader {
    private final NumberParser numberParser;

    public DataReaderImpl(NumberParser numberParser) {
        this.numberParser = numberParser;
    }

    @Override
    public List<Integer> readNumbersFromFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    numbers.add(numberParser.parse(line.trim()));
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid number format: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read data from file: " + filePath, e);
        }
        return numbers;
    }
}
