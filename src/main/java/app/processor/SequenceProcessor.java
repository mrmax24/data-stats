package app.processor;

import java.util.ArrayList;
import java.util.List;

public class SequenceProcessor {
    private final List<Integer> numbers;

    public SequenceProcessor(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

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
