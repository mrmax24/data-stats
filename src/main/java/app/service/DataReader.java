package app.service;

import java.util.List;

public interface DataReader {
    List<Integer> readNumbersFromFile(String filePath);
}
