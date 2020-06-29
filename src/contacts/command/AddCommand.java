package contacts.command;

import contacts.Records;
import contacts.model.ConsumerFactory;
import contacts.model.OrganizationFactory;
import contacts.model.PersonFactory;
import contacts.util.IO;

public class AddCommand implements Command {
    private final IO io;
    private final Records records;

    public AddCommand(IO io, Records records) {
        this.io = io;
        this.records = records;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public void execute() {
        String type = io.read("Enter the type (person, organization)");
        ConsumerFactory factory = type.equals("person") ? new PersonFactory(io) : new OrganizationFactory(io);
        records.add(factory.create());
        System.out.println("The record added.");
    }
}
