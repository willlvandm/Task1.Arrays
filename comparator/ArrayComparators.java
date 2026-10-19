package arrayapp.comparator;

import arrayapp.entity.IntArrayEntity;
import java.util.Arrays;
import java.util.Comparator;

public final class ArrayComparators {

    public static final Comparator<IntArrayEntity> BY_ID =
            Comparator.comparingInt(IntArrayEntity::getId);

    public static final Comparator<IntArrayEntity> BY_NAME =
            Comparator.comparing(IntArrayEntity::getName);

    public static final Comparator<IntArrayEntity> BY_FIRST_ELEMENT =
            Comparator.comparingInt(ArrayComparators::firstValue);

    public static final Comparator<IntArrayEntity> BY_SIZE =
            Comparator.comparingInt(IntArrayEntity::size);

    public static final Comparator<IntArrayEntity> BY_SUM =
            Comparator.comparingInt(ArrayComparators::sum);

    private ArrayComparators() {
    }

    private static int firstValue(IntArrayEntity array) {
        if (array.size() == 0) {
            return Integer.MAX_VALUE;
        }

        return array.getValue(0);
    }

    private static int sum(IntArrayEntity array) {
        return Arrays.stream(array.getValues()).sum();
    }
}
