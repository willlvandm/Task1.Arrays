package arrayapp.entity;

public class IntArrayBuilder {

    private int id;
    private String name = "";
    private int[] values = new int[0];

    public IntArrayBuilder id(int newId) {
        this.id = newId;
        return this;
    }

    public IntArrayBuilder name(String newName) {
        this.name = newName;
        return this;
    }

    public IntArrayBuilder values(int[] newValues) {
        this.values = newValues.clone();
        return this;
    }

    public IntArrayEntity build() {
        return new IntArrayEntity(id, name, values);
    }
}