package contacts.command;

import contacts.Records;

public class CountCommand implements Command {
    private final Records records;

    public CountCommand(Records records) {
        this.records = records;
    }

    @Override
    public String getName() {
        return "count";
    }

    @Override
    public void execute() {
        System.out.printf("The Phone Book has %d records.\n", records.size());
    }
}
