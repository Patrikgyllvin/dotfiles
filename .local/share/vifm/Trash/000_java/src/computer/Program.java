package computer;

import computer.instruction.core.InstructionCommand;

import java.util.ArrayList;
import java.util.List;

public abstract class Program {
    List<InstructionCommand> instructions = new ArrayList<>();

    public void add(InstructionCommand instruction) {
        instructions.add(instruction);
    }

    public void run(Memory memory) {
        for (InstructionCommand instruction : instructions) {
            instruction.execute(memory);
        }
    }
}
