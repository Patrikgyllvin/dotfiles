package computer.word.core;

public class Word<T extends Number> {
    T value;

    public Word(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

