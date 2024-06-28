package app.service.impl;

import app.processor.SequenceProcessor;
import app.processor.StatisticsProcessor;
import app.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DELIMITER = ": ";
    private static final String MAX_NUMBER_LABEL = "Maximum number";
    private static final String MIN_NUMBER_LABEL = "Minimum number";
    private static final String MEDIAN_LABEL = "Median";
    private static final String AVERAGE_LABEL = "Average";
    private static final String INC_SEQUENCE_LABEL = "Longest Increasing Sequence";
    private static final String DEC_SEQUENCE_LABEL = "Longest Decreasing Sequence";
    private final StatisticsProcessor statisticsProcessor;
    private final SequenceProcessor sequenceProcessor;

    public ReportGeneratorImpl(StatisticsProcessor statisticsProcessor,
                               SequenceProcessor sequenceProcessor) {
        this.statisticsProcessor = statisticsProcessor;
        this.sequenceProcessor = sequenceProcessor;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        appendLine(report, MAX_NUMBER_LABEL, statisticsProcessor.findMax());
        appendLine(report, MIN_NUMBER_LABEL, statisticsProcessor.findMin());
        appendLine(report, MEDIAN_LABEL, statisticsProcessor.findMedian());
        appendLine(report, AVERAGE_LABEL, statisticsProcessor.findAverage());
        appendLine(report, INC_SEQUENCE_LABEL,
                sequenceProcessor.findLongestIncreasingSequence());
        appendLine(report, DEC_SEQUENCE_LABEL,
                sequenceProcessor.findLongestDecreasingSequence());

        return report.toString();
    }

    private void appendLine(StringBuilder report, String label, Object value) {
        report.append(label).append(DELIMITER).append(value).append(System.lineSeparator());
    }
}
