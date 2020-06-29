package contacts.command;

public class ExitCommand implements Command {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute() {
        throw new OutOfMemoryError("DONT EXECUTE ME!!!");
    }
}
