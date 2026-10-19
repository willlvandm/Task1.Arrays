package arrayapp.repository;

import arrayapp.entity.IntArrayEntity;
import arrayapp.event.ArrayChangePublisher;
import arrayapp.specification.Specification;
import arrayapp.warehouse.Warehouse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IntArrayRepository {

    private static IntArrayRepository instance;

    private final Map<Integer, IntArrayEntity> arraysById = new LinkedHashMap<>();

    private IntArrayRepository() {
        ArrayChangePublisher.getInstance().subscribe(Warehouse.getInstance());
    }

    public static IntArrayRepository getInstance() {
        if (instance == null) {
            instance = new IntArrayRepository();
        }
        return instance;
    }

    public void add(IntArrayEntity array) {
        arraysById.put(array.getId(), array);
        Warehouse.getInstance().onArrayChanged(array);
    }

    public void remove(int id) {
        arraysById.remove(id);
        Warehouse.getInstance().removeStatistics(id);
    }

    public IntArrayEntity getById(int id) {
        return arraysById.get(id);
    }

    public List<IntArrayEntity> getAll() {
        return new ArrayList<>(arraysById.values());
    }

    public List<IntArrayEntity> find(Specification<IntArrayEntity> specification) {
        List<IntArrayEntity> result = new ArrayList<>();

        for (IntArrayEntity array : arraysById.values()) {
            if (specification.isSatisfiedBy(array)) {
                result.add(array);
            }
        }

        return result;
    }

    public void sort(Comparator<IntArrayEntity> comparator) {
        List<IntArrayEntity> sortedArrays = getAll();
        sortedArrays.sort(comparator);

        arraysById.clear();

        for (IntArrayEntity array : sortedArrays) {
            arraysById.put(array.getId(), array);
        }
    }
}
