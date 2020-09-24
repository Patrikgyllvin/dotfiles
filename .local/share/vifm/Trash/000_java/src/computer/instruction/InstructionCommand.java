package computer.instruction

import computer.memory;

public interface InstructionCommand {
    int execute(int programCounter);
}
