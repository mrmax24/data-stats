package org.example.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultWriter {
    public void writeResultsToFile(String fileName, int max, int min, double median,
                                   double average, List<Integer> longestIncreasingSequence,
                                   List<Integer> longestDecreasingSequence, double timeInSeconds) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Maximum number: " + max);
            writer.newLine();
            writer.write("Minimum number: " + min);
            writer.newLine();
            writer.write("Median: " + median);
            writer.newLine();
            writer.write("Average: " + average);
            writer.newLine();
            writer.write("Longest Increasing Sequence: " + longestIncreasingSequence);
            writer.newLine();
            writer.write("Longest Decreasing Sequence: " + longestDecreasingSequence);
            writer.newLine();
            writer.write("Response time: " + timeInSeconds + " seconds");
        } catch (IOException e) {
            throw new RuntimeException("Failed to write results to file: " + fileName, e);
        }
    }
}
