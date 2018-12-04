package pattern.builder;

public class AnotherComputerBuilder extends ComputerBuilder {
    @Override
    public void buildDisplay() {
        computer.setDisplay("Display 19'");
    }

    @Override
    public void buildSystemBlock() {
        computer.setSystemBlock("SystemBlock Acer");
    }

    @Override
    public void buildManipulators() {
        computer.setManipulators("Joystick");
    }
}
