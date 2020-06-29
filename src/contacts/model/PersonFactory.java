package contacts.model;

import contacts.field.FieldEditor;
import contacts.util.IO;

public class PersonFactory extends AbstractConsumerFactory<Person> {
    public PersonFactory(IO io) {
        super(io);
    }

    @Override
    public FieldEditor<Person> getFieldEditor() {
        return Person.FIELD_EDITOR;
    }

    @Override
    public Person createEmpty() {
        return new Person();
    }
}
