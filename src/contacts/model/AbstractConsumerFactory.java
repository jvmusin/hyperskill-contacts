package contacts.model;

import contacts.field.Field;
import contacts.field.FieldEditor;
import contacts.util.IO;

public abstract class AbstractConsumerFactory<T extends Consumer> implements ConsumerFactory {
    private final IO io;

    protected AbstractConsumerFactory(IO io) {
        this.io = io;
    }

    public abstract FieldEditor<T> getFieldEditor();

    public abstract T createEmpty();

    @Override
    public Consumer create() {
        T result = createEmpty();
        for (Field<T> field : getFieldEditor().getFields()) {
            field.edit(result, io.read("Enter the " + field.getFullName()));
        }
        return result;
    }
}