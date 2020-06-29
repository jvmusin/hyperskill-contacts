package contacts.command;

import contacts.util.IO;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MenuCommand implements Command {
    private final IO io;
    private final List<Command> commands;

    public MenuCommand(IO io, List<Command> commands) {
        this.io = io;
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "menu";
    }

    @Override
    public void execute() {
        Map<String, Command> nameToCommand = commands.stream()
                .collect(Collectors.toMap(Command::getName, Function.identity()));
        String prompt = commands.stream()
                .map(Command::getName)
                .collect(Collectors.joining(", ", "[menu] Enter action (", ")"));
        while (true) {
            String command = io.read(prompt);
            if (command.equals("exit")) break;
            nameToCommand.get(command).execute();
            System.out.println();
        }
    }
}
