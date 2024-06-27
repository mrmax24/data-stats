package app.service.impl;

import app.processor.impl.SequenceProcessorImpl;
import app.processor.impl.StatisticsProcessorImpl;
import app.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DELIMITER = ": ";
    private static final String MAX_NUMBER_LABEL = "Maximum number";
    private static final String MIN_NUMBER_LABEL = "Minimum number";
    private static final String MEDIAN_LABEL = "Median";
    private static final String AVERAGE_LABEL = "Average";
    private static final String INC_SEQUENCE_LABEL = "Longest Increasing Sequence";
    private static final String DEC_SEQUENCE_LABEL = "Longest Decreasing Sequence";
    private final StatisticsProcessorImpl statisticsProcessorImpl;
    private final SequenceProcessorImpl sequenceProcessorImpl;

    public ReportGeneratorImpl(StatisticsProcessorImpl statisticsProcessorImpl,
                               SequenceProcessorImpl sequenceProcessorImpl) {
        this.statisticsProcessorImpl = statisticsProcessorImpl;
        this.sequenceProcessorImpl = sequenceProcessorImpl;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        appendLine(report, MAX_NUMBER_LABEL, statisticsProcessorImpl.findMax());
        appendLine(report, MIN_NUMBER_LABEL, statisticsProcessorImpl.findMin());
        appendLine(report, MEDIAN_LABEL, statisticsProcessorImpl.findMedian());
        appendLine(report, AVERAGE_LABEL, statisticsProcessorImpl.findAverage());
        appendLine(report, INC_SEQUENCE_LABEL,
                sequenceProcessorImpl.findLongestIncreasingSequence());
        appendLine(report, DEC_SEQUENCE_LABEL,
                sequenceProcessorImpl.findLongestDecreasingSequence());

        return report.toString();
    }

    private void appendLine(StringBuilder report, String label, Object value) {
        report.append(label).append(DELIMITER).append(value).append(System.lineSeparator());
    }
}
