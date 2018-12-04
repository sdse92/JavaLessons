package pattern.builder;

public class Main {
    public static void main(String[] args) {
//        Computer computer = new Computer();
//        computer.setDisplay("Display");
//        computer.setManipulators("Manipulators");
//        computer.setSystemBlock("Block");
        Director director = new Director();
        ComputerBuilder computerBuilder = new AnotherComputerBuilder();

        director.setComputerBuilder(computerBuilder);
        director.constructComputer();

        Computer computer = director.getComputer();
        System.out.println(computer);
    }
}
