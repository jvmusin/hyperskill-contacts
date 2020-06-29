package contacts.command;

import contacts.Records;
import contacts.model.Consumer;
import contacts.util.IO;

public class ListCommand implements Command {
    private final IO io;
    private final Records records;

    public ListCommand(IO io, Records records) {
        this.io = io;
        this.records = records;
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public void execute() {
        new RecordsListPrinter(records).print();
        String action = io.read("[list] Enter action ([number], back)");
        if (action.equals("back")) return;
        int index = Integer.parseInt(action);
        Consumer record = records.get(index - 1);
        System.out.println(record.getInfo());
        System.out.println();

        new RecordCommand(io, records, record).execute();
    }
}
