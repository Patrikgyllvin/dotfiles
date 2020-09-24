package computer;

public class Computer {
    private final Memory memory;
    private Program program;

    public Computer(Memory memory) {
        this.memory = memory;
    }

    public void load(Program program) {
        this.program = program;
    }

    public void run() {
        program.run(memory);
    }

}
