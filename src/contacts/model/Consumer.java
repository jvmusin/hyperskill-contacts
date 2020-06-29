package contacts.model;

import contacts.field.FieldEditor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

import static contacts.util.Validators.isNumberValid;

public abstract class Consumer implements Serializable {
    private final LocalDateTime timeCreated = LocalDateTime.now();
    private LocalDateTime timeLastEdit = timeCreated;
    private String name;
    private String number = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updated();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        updated();
        if (isNumberValid(number)) {
            this.number = number;
            return;
        }
        System.out.println("Wrong number format!");
        this.number = "";
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeLastEdit() {
        return timeLastEdit;
    }

    protected void updated() {
        timeLastEdit = LocalDateTime.now();
    }

    protected String formatField(String name, Object value) {
        return String.format("%s: %s", name, value == null ? "[no data]" : value);
    }

    public String getInfo() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add(formatField("Number", getNumber()));
        sj.add(formatField("Time created", getTimeCreated()));
        sj.add(formatField("Time last edit", getTimeLastEdit()));
        return sj.toString();
    }

    public abstract FieldEditor<?> getFieldEditor();

    public abstract void editField(String fieldName, String newValue);
}