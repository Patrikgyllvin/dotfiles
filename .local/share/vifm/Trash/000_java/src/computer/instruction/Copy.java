package computer.instruction;

import computer.Memory;
import computer.instruction.core.InstructionCommand;
import computer.word.Address;
import computer.word.core.Word;

public class Copy implements InstructionCommand {

    private final Word<?> word;
    private final Address address;

    public Copy(Word<?> word, Address address) {
        this.word = word;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Copy %s to [%s]", word.getValue(), address.getValue());
    }

    @Override
    public void execute(Memory memory) {
        memory.words[address.getValue()] = new Word(word.getValue());
    }
}
