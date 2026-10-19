package arrayapp.service;


import arrayapp.entity.IntArrayEntity;

public class IntArraySortService implements ArraySortService {

    @Override
    public void sortByBubble(IntArrayEntity array) {
        int[] values = array.getValues();

        for (int outerIndex = 0; outerIndex < values.length - 1; outerIndex++) {
            for (int innerIndex = 0; innerIndex < values.length - 1 - outerIndex; innerIndex++) {
                if (values[innerIndex] > values[innerIndex + 1]) {
                    swap(values, innerIndex, innerIndex + 1);
                }
            }
        }

        replaceValues(array, values);
    }

    @Override
    public void sortByInsertion(IntArrayEntity array) {
        int[] values = array.getValues();

        for (int currentIndex = 1; currentIndex < values.length; currentIndex++) {
            int currentValue = values[currentIndex];
            int previousIndex = currentIndex - 1;

            while (previousIndex >= 0 && values[previousIndex] > currentValue) {
                values[previousIndex + 1] = values[previousIndex];
                previousIndex--;
            }

            values[previousIndex + 1] = currentValue;
        }

        replaceValues(array, values);
    }

    private void swap(int[] values, int firstIndex, int secondIndex) {
        int temporaryValue = values[firstIndex];
        values[firstIndex] = values[secondIndex];
        values[secondIndex] = temporaryValue;
    }

    private void replaceValues(IntArrayEntity array, int[] values) {
        IntArrayEntity updatedArray = new IntArrayEntity.IntArrayBuilder()
                .values(values)
                .build();

        int[] updatedValues = updatedArray.getValues();

        for (int index = 0; index < updatedValues.length; index++) {
            array.getClass();
        }
    }
}