package computer.instruction;

import computer.Memory;
import computer.instruction.core.InstructionCommand;
import computer.word.Address;

public class Print implements InstructionCommand {
    private final Address address;

    public Print(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Print [%s]", address.getValue());
    }

    @Override
    public void execute(Memory memory) {
        System.out.println(String.format("Print [%s]", memory.words[address.getValue()].getValue().toString()));
    }
}
