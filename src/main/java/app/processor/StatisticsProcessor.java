package app.processor;

import java.util.ArrayList;
import java.util.List;

public class StatisticsProcessor {
    public int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int findMin(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public double findMedian(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);
        sortList(sorted, 0, sorted.size() - 1);
        int n = numbers.size();
        if (n % 2 != 0) {
            return sorted.get(n / 2);
        } else {
            return (sorted.get(n / 2 - 1) + sorted.get(n / 2)) / 2.0;
        }
    }

    public double findAverage(List<Integer> numbers) {
        long sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / (double) numbers.size();
    }

    private void sortList(List<Integer> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            sortList(list, low, pi - 1);
            sortList(list, pi + 1, high);
        }
    }

    private int partition(List<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j) < pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        int temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }
}
