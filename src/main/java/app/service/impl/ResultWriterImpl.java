package app.service.impl;

import app.service.ResultWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResultWriterImpl implements ResultWriter {
    @Override
    public void writeToFile(String info, String filePath) {
        try {
            Files.write(Path.of(filePath), info.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to file with path: " + filePath, e);
        }
    }
}
