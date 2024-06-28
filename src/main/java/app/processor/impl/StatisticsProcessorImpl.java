package app.processor.impl;

import app.processor.StatisticsProcessor;
import java.util.ArrayList;
import java.util.List;

public class StatisticsProcessorImpl implements StatisticsProcessor {
    private final List<Integer> numbers;

    public StatisticsProcessorImpl(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public int findMax() {
        int max = numbers.get(0);
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @Override
    public int findMin() {
        int min = numbers.get(0);
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    @Override
    public double findMedian() {
        sortList(0, numbers.size() - 1);
        int size = numbers.size();
        if (size % 2 != 0) {
            return numbers.get(size / 2);
        } else {
            return (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2.0;
        }
    }

    @Override
    public double findAverage() {
        long sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / (double) numbers.size();
    }

    private void sortList(int low, int high) {
        if (low < high) {
            int partitionIndex = partition(low, high);
            sortList(low, partitionIndex - 1);
            sortList(partitionIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int keyElement = numbers.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (numbers.get(j) < keyElement) {
                i++;
                int temp = numbers.get(i);
                numbers.set(i, numbers.get(j));
                numbers.set(j, temp);
            }
        }
        int temp = numbers.get(i + 1);
        numbers.set(i + 1, numbers.get(high));
        numbers.set(high, temp);
        return i + 1;
    }
}
