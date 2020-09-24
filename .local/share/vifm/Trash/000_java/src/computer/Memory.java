package computer;

import computer.word.core.Word;
import computer.word.core.WordFactory;

public class Memory {
    public Word<?>[] words;
    private final WordFactory<?> wordFactory;

    public Memory(int i, WordFactory<?> wordFactory) {
        words = new Word[i];
        this.wordFactory = wordFactory;
    }

    public WordFactory<?> getWordFactory() {
        return this.wordFactory;
    }
}
