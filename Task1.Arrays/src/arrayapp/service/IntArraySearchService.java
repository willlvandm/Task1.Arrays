package arrayapp.service;

import arrayapp.entity.IntArrayEntity;
import java.util.Optional;

public class IntArraySearchService implements ArraySearchService {

    @Override
    public Optional<Integer> findMin(IntArrayEntity array) {
        int[] values = array.getValues();

        if (values.length == 0) {
            return Optional.empty();
        }

        int minimum = values[0];

        for (int value : values) {
            if (value < minimum) {
                minimum = value;
            }
        }

        return Optional.of(minimum);
    }

    @Override
    public Optional<Integer> findMax(IntArrayEntity array) {
        int[] values = array.getValues();

        if (values.length == 0) {
            return Optional.empty();
        }

        int maximum = values[0];

        for (int value : values) {
            if (value > maximum) {
                maximum = value;
            }
        }

        return Optional.of(maximum);
    }
}
