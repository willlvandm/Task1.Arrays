package arrayapp.entity;

import arrayapp.event.ArrayChangePublisher;

public class IntArrayEntity {

    private final int id;
    private final String name;
    private int[] values;

    public IntArrayEntity(int id, String name, int[] values) {
        this.id = id;
        this.name = name;
        this.values = values.clone();
        ArrayChangePublisher.getInstance().publishChange(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getValues() {
        return values.clone();
    }

    public int getValue(int index) {
        return values[index];
    }

    public int size() {
        return values.length;
    }

    public void setValue(int index, int value) {
        values[index] = value;
        ArrayChangePublisher.getInstance().publishChange(this);
    }

    public void setValues(int[] newValues) {
        this.values = newValues.clone();
        ArrayChangePublisher.getInstance().publishChange(this);
    }

    @Override
    public String toString() {
        return "IntArrayEntity{id=" + id
                + ", name='" + name + "'"
                + ", values=" + java.util.Arrays.toString(values) + "}";
    }
}