package app;

import app.fileservice.DataReader;
import app.fileservice.ResultWriter;
import app.processor.SequenceProcessor;
import app.processor.StatisticsProcessor;
import app.service.ReportGenerator;
import java.util.List;

public class Main {
    private static final double MS_IN_SEC = 1000.0;
    private static final String INPUT_FILE_PATH = "src/main/resources/10m.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.txt";
    private static final String EXECUTION_TIME_LABEL = "Execution time: %.2f seconds";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        DataReader dataReader = new DataReader();
        List<Integer> numbers = dataReader.readNumbersFromFile(INPUT_FILE_PATH);

        StatisticsProcessor statisticsProcessor = new StatisticsProcessor(numbers);
        SequenceProcessor sequenceProcessor = new SequenceProcessor(numbers);

        ReportGenerator reportGenerator = new ReportGenerator(
                statisticsProcessor, sequenceProcessor);
        String report = reportGenerator.generateReport();

        long end = System.currentTimeMillis();
        double timeInSeconds = (end - start) / MS_IN_SEC;
        report += String.format(System.lineSeparator() + EXECUTION_TIME_LABEL, timeInSeconds);

        ResultWriter resultWriter = new ResultWriter();
        resultWriter.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
