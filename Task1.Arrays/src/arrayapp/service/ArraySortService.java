package arrayapp.service;

import arrayapp.entity.IntArrayEntity;

public interface ArraySortService {

    void sortByBubble(IntArrayEntity array);

    void sortByInsertion(IntArrayEntity array);
}
