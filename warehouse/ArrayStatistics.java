package arrayapp.warehouse;

public class ArrayStatistics {

    private final int id;
    private final String name;
    private long sum;
    private double average;
    private int minimum;
    private int maximum;

    public ArrayStatistics(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void recalculate(int[] values) {
        if (values.length == 0) {
            sum = 0;
            average = 0.0;
            minimum = 0;
            maximum = 0;
            return;
        }

        sum = 0;
        minimum = values[0];
        maximum = values[0];

        for (int value : values) {
            sum += value;
            minimum = Math.min(minimum, value);
            maximum = Math.max(maximum, value);
        }

        average = (double) sum / values.length;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    @Override
    public String toString() {
        return "ArrayStatistics{id=" + id
                + ", name='" + name + "'"
                + ", sum=" + sum
                + ", average=" + average
                + ", min=" + minimum
                + ", max=" + maximum + "}";
    }
}
