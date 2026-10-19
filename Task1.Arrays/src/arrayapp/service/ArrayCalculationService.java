package arrayapp.service;

import arrayapp.entity.IntArrayEntity;
import java.util.Optional;

public interface ArrayCalculationService {

    Optional<Long> calculateSum(IntArrayEntity array);

    Optional<Double> calculateAverage(IntArrayEntity array);
}
