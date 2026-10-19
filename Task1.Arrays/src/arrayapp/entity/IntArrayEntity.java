package arrayapp.entity;

public class IntArrayEntity {

    private final int[] values;

    private IntArrayEntity(int[] values) {
        this.values = values;
    }

    public int[] getValues() {
        return values.clone();
    }

    public int size() {
        return values.length;
    }

    public int getValue(int index) {
        return values[index];
    }

    public static class IntArrayBuilder {

        private int[] values = new int[0];

        public IntArrayBuilder values(int[] newValues) {
            this.values = newValues.clone();
            return this;
        }

        public IntArrayEntity build() {
            return new IntArrayEntity(values);
        }
    }
}
