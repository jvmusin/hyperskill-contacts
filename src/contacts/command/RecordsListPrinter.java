package contacts.command;

import contacts.Records;

public class RecordsListPrinter {
    private final Records records;

    public RecordsListPrinter(Records records) {
        this.records = records;
    }

    public void print() {
        for (int i = 0; i < records.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, records.get(i));
        }
        System.out.println();
    }
}
