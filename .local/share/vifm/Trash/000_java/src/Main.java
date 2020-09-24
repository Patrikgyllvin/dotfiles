import computer.Computer;
import computer.Memory;
import computer.Program;
import computer.instruction.Copy;
import computer.instruction.Print;
import computer.word.Address;
import computer.word.LongWordFactory;
import computer.word.core.WordFactory;

public class Main {
    public static void main(String[] args) {
        LongWordFactory lwf = new LongWordFactory();
        run("A test program", new Test("5", lwf), lwf);
    }

    static void run(String message, Program program, WordFactory<?> wf) {
        System.out.println("================================");
        System.out.println(message);
        System.out.println(program);
        Computer computer = new Computer(new Memory(1024, wf));
        computer.load(program);
        computer.run();
    }
}


class Test extends Program {
    public Test(String value, WordFactory<?> wf) {
        Address n1 = new Address(0);
        Address n2 = new Address(1);

        add(new Copy(wf.word("50"), n1));
        add(new Copy(wf.word("100"), n2));
        add(new Print(n1));
        add(new Print(n2));
    }



}
