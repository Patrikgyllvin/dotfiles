package computer.word;

import computer.word.core.WordFactory;

public class LongWordFactory implements WordFactory<Long> {

    @Override
    public LongWord word(String s) {
        return new LongWord(Long.parseLong(s));
    }
}
