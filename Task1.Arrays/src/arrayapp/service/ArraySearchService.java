package arrayapp.service;

import arrayapp.entity.IntArrayEntity;
import java.util.Optional;

public interface ArraySearchService {

    Optional<Integer> findMin(IntArrayEntity array);

    Optional<Integer> findMax(IntArrayEntity array);
}
