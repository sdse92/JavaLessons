package pattern.command;

import java.util.Scanner;

public class TextProcessor {
    private CommandHistory history = new CommandHistory();
    //перечислить все комманды

    public void executeCommand(Command command){
        if (command.execute()){
            history.add(command);
        }
    }

    public void start(){
        Scanner in = new Scanner(System.in);
        while (true){
            switch (in.nextLine()){
                case "process":
                    executeCommand(new ProcessCommand(this));
                    break;
                case "exit":
                    executeCommand(new ExitCommand(this));
                    break;
            }
            if (in.nextLine().equals("process")){
                executeCommand(new ProcessCommand(this));
            }
        }
    }
}
