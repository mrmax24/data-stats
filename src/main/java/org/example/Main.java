package org.example;

import java.util.List;
import org.example.processor.SequenceProcessor;
import org.example.processor.StatisticsProcessor;
import org.example.reader.DataReader;
import org.example.writer.ResultWriter;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/10m.txt";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/result.txt";
    private static final double MS_IN_SEC = 1000.0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        DataReader dataReader = new DataReader();
        List<Integer> numbers = dataReader.readNumbersFromFile(INPUT_FILE_NAME);

        StatisticsProcessor statisticsProcessor = new StatisticsProcessor();
        int max = statisticsProcessor.findMax(numbers);
        int min = statisticsProcessor.findMin(numbers);
        double median = statisticsProcessor.findMedian(numbers);
        double average = statisticsProcessor.findAverage(numbers);

        SequenceProcessor sequenceProcessor = new SequenceProcessor();
        List<Integer> longestIncreasingSequence
                = sequenceProcessor.findLongestIncreasingSequence(numbers);
        List<Integer> longestDecreasingSequence
                = sequenceProcessor.findLongestDecreasingSequence(numbers);

        long end = System.currentTimeMillis();
        double timeInSeconds = (end - start) / MS_IN_SEC;

        ResultWriter resultWriter = new ResultWriter();
        resultWriter.writeResultsToFile(OUTPUT_FILE_NAME, max, min, median, average,
                longestIncreasingSequence, longestDecreasingSequence, timeInSeconds);
    }
}
