package computer.word.core;

public interface WordFactory<T extends Number> {
    Word<T> word(String s);
}
