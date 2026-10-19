package arrayapp.service;

import arrayapp.entity.IntArrayEntity;
import java.util.Optional;

public class IntArrayCalculationService implements ArrayCalculationService {

    @Override
    public Optional<Long> calculateSum(IntArrayEntity array) {
        int[] values = array.getValues();

        if (values.length == 0) {
            return Optional.empty();
        }

        long sum = 0;

        for (int value : values) {
            sum += value;
        }

        return Optional.of(sum);
    }

    @Override
    public Optional<Double> calculateAverage(IntArrayEntity array) {
        Optional<Long> sum = calculateSum(array);

        if (sum.isEmpty()) {
            return Optional.empty();
        }

        double average = (double) sum.get() / array.size();
        return Optional.of(average);
    }
}
