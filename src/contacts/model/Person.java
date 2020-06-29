package contacts.model;

import contacts.field.FieldEditor;

import java.time.LocalDate;
import java.util.StringJoiner;

import static contacts.util.Validators.tryParseBirthday;
import static contacts.util.Validators.tryParseGender;

public class Person extends Consumer {

    public static final FieldEditor<Person> FIELD_EDITOR = new FieldEditor.Builder<Person>()
            .addField("name", "name", Person::setName)
            .addField("surname", "surname", Person::setSurname)
            .addField("birth", "birth date", Person::setBirthday)
            .addField("gender", "gender (M, F)", Person::setGender)
            .addField("number", "number", Person::setNumber)
            .build();

    private String surname;
    private LocalDate birthday;
    private Character gender;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        updated();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if ((this.birthday = tryParseBirthday(birthday)) == null) {
            System.out.println("Bad birth date!");
        }
        updated();
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if ((this.gender = tryParseGender(gender)) == null) {
            System.out.println("Bad gender!");
        }
        updated();
    }

    @Override
    public String toString() {
        return String.format("%s %s", getName(), getSurname());
    }

    @Override
    public String getInfo() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add(formatField("Name", getName()));
        sj.add(formatField("Surname", getSurname()));
        sj.add(formatField("Birth date", getBirthday()));
        sj.add(formatField("Gender", getGender()));
        sj.add(super.getInfo());
        return sj.toString();
    }

    @Override
    public void editField(String fieldName, String newValue) {
        FIELD_EDITOR.edit(this, fieldName, newValue);
    }

    @Override
    public FieldEditor<Person> getFieldEditor() {
        return FIELD_EDITOR;
    }
}
