package pattern.command;

public class ExitCommand extends Command {
    public ExitCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return null;
    }

    @Override
    boolean execute() {
        System.out.println("выход");
        return true;
    }
}
