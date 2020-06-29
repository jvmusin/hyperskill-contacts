package contacts.command;

import contacts.util.IO;
import contacts.Records;

public class InfoCommand implements Command {
    private final IO io;
    private final Records records;
    private final RecordsListPrinter recordsListPrinter;

    public InfoCommand(IO io, Records records) {
        this.io = io;
        this.records = records;
        this.recordsListPrinter = new RecordsListPrinter(records);
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public void execute() {
        recordsListPrinter.print();
        int index = io.readInt("Enter index to show info");
        System.out.println(records.get(index - 1).getInfo());
    }
}
