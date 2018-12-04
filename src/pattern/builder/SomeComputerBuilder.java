package pattern.builder;

public class SomeComputerBuilder extends ComputerBuilder{
    @Override
    public void buildDisplay() {
        computer.setDisplay("Some Display");
    }

    @Override
    public void buildSystemBlock() {
        computer.setSystemBlock("Some SystemBlock");
    }

    @Override
    public void buildManipulators() {
        computer.setManipulators("Some Manipulators");
    }
}
