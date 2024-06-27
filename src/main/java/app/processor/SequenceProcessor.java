package app.processor;

import java.util.List;

public interface SequenceProcessor {
    List<Integer> findLongestIncreasingSequence();

    List<Integer> findLongestDecreasingSequence();
}
