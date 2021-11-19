package day05;

public class TypeCount {

    private final Type type;
    private int count;

    public TypeCount(Type type) {
        this.type = type;
        count = 1;
    }

    public Type getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}
