package arrayapp.warehouse;

import arrayapp.entity.IntArrayEntity;
import arrayapp.event.ArrayChangeObserver;
import java.util.HashMap;
import java.util.Map;

public class Warehouse implements ArrayChangeObserver {

    private static Warehouse instance;

    private final Map<Integer, ArrayStatistics> statisticsById = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    @Override
    public void onArrayChanged(IntArrayEntity array) {
        ArrayStatistics statistics = statisticsById.computeIfAbsent(
                array.getId(),
                id -> new ArrayStatistics(array.getId(), array.getName())
        );

        statistics.recalculate(array.getValues());
    }

    public ArrayStatistics getStatistics(int id) {
        return statisticsById.get(id);
    }

    public void removeStatistics(int id) {
        statisticsById.remove(id);
    }
}
