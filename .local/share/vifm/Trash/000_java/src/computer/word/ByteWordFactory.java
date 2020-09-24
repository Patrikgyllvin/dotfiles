package computer.word;

import computer.word.core.WordFactory;

public class ByteWordFactory implements WordFactory<Byte> {

    @Override
    public ByteWord word(String s) {
        return new ByteWord(Byte.valueOf(s));
    }
}
