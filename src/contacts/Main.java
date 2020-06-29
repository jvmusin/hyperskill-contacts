package contacts;

import contacts.command.*;
import contacts.model.Organization;
import contacts.model.Person;
import contacts.util.IO;

import java.io.*;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) throws Exception {
        if (false) init();

        String fileName = args.length == 0 ? null : args[0];
        Records records = fileName == null ? new Records() : readFromFile(fileName);

        IO io = new IO();
        List<Command> commands = asList(
                new AddCommand(io, records),
                new ListCommand(io, records),
                new SearchCommand(io, records),
                new CountCommand(records),
                new ExitCommand()
        );
        new MenuCommand(io, commands).execute();

        if (fileName != null) saveToFile(records, args[0]);
    }

    private static void init() throws IOException {
        Records records = new Records();

        records.add(new Organization() {{
            setName("Car Shop");
            setAddress("Wall St. 3");
            setNumber("+0 (123) 456-789-9999");
        }});
        records.add(new Organization() {{
            setName("Decent Pizza Shop");
            setAddress("Pz street 22");
            setNumber("+0 (124) 123-456-7777");
        }});
        records.add(new Organization() {{
            setName("Central Bank");
            setAddress("CB street 22");
            setNumber("+0 (125) 444-445-1234");
        }});
        records.add(new Person() {{
            setName("Centurion");
            setSurname("Adams");
            setGender("M");
            setNumber("+123923 (173) 12-27-74-47");
        }});
        records.add(new Person() {{
            setName("John");
            setSurname("Smith");
            setGender("M");
            setNumber("+903923 (973) 99-27-74-49");
        }});
        records.add(new Person() {{
            setName("Alice");
            setSurname("Wonderlanded");
            setGender("F");
            setNumber("+123123 (123) 12-23-34-45");
        }});
        new ObjectOutputStream(new FileOutputStream("phonebook.db")).writeObject(records);
    }

    private static Records readFromFile(String fileName) {
        try {
            return (Records) new ObjectInputStream(new FileInputStream(fileName)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Records();
        }
    }

    private static void saveToFile(Records records, String fileName) throws IOException {
        new ObjectOutputStream(new FileOutputStream(fileName)).writeObject(records);
    }
}