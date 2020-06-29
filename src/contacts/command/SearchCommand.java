package contacts.command;

import contacts.Records;
import contacts.util.IO;

public class SearchCommand implements Command {
    private final IO io;
    private final Records records;

    public SearchCommand(IO io, Records records) {
        this.io = io;
        this.records = records;
    }

    @Override
    public String getName() {
        return "search";
    }

    @Override
    public void execute() {
        String query = io.read("Enter search query");
        Records filtered = records.filter(query);
        System.out.printf("Found %d result%s:\n", filtered.size(), filtered.size() % 10 == 1 ? "" : "s");
        new RecordsListPrinter(filtered).print();

        String action = io.read("[search] Enter action ([number], back, again)");
        if (action.equals("again")) {
            execute();
        } else if (!action.equals("back")) {
            try {
                int index = Integer.parseInt(action);
                new RecordCommand(io, records, records.get(index - 1)).execute();
            } catch (NumberFormatException ignored) {
                // not a number, just return
            }
        }
    }
}
