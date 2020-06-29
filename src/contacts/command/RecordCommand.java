package contacts.command;

import contacts.Records;
import contacts.model.Consumer;
import contacts.util.IO;

import static java.util.stream.Collectors.joining;

public class RecordCommand implements Command {
    private final IO io;
    private final Records records;
    private final Consumer consumer;

    public RecordCommand(IO io, Records records, Consumer consumer) {
        this.io = io;
        this.records = records;
        this.consumer = consumer;
    }

    @Override
    public String getName() {
        return "record";
    }

    @Override
    public void execute() {
        String action = io.read("Enter action (edit, delete, menu)");

        if (action.equals("edit")) handleEdit();
        else if (action.equals("delete")) records.remove(consumer);
        else if (!action.equals("menu")) throw new IllegalArgumentException("Unknown action: " + action);
    }

    private void handleEdit() {
        String prompt = consumer.getFieldEditor().getFieldNames().stream()
                .collect(joining(", ", "Select a field (", ")"));
        String field = io.read(prompt);
        String value = io.read("Enter " + field);
        consumer.editField(field, value);
        System.out.println("Saved");
        System.out.println(consumer.getInfo());

        System.out.println();
        execute();
    }
}
