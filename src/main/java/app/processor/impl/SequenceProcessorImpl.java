package app.processor.impl;

import app.processor.SequenceProcessor;
import java.util.ArrayList;
import java.util.List;

public class SequenceProcessorImpl implements SequenceProcessor {
    private final List<Integer> numbers;

    public SequenceProcessorImpl(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public List<Integer> findLongestIncreasingSequence() {
        List<Integer> longest = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        for (Integer number : numbers) {
            if (current.isEmpty() || number > current.get(current.size() - 1)) {
                current.add(number);
            } else {
                if (current.size() > longest.size()) {
                    longest = new ArrayList<>(current);
                }
                current.clear();
                current.add(number);
            }
        }
        if (current.size() > longest.size()) {
            longest = current;
        }
        return longest;
    }

    @Override
    public List<Integer> findLongestDecreasingSequence() {
        List<Integer> longest = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        for (Integer number : numbers) {
            if (current.isEmpty() || number < current.get(current.size() - 1)) {
                current.add(number);
            } else {
                if (current.size() > longest.size()) {
                    longest = new ArrayList<>(current);
                }
                current.clear();
                current.add(number);
            }
        }
        if (current.size() > longest.size()) {
            longest = current;
        }
        return longest;
    }
}
