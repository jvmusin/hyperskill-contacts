package contacts.field;

import java.util.function.BiConsumer;

public class AbstractField<T> implements Field<T> {
    private final String shortName;
    private final String fullName;
    private final BiConsumer<T, String> editField;

    public AbstractField(String shortName, String fullName, BiConsumer<T, String> editField) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.editField = editField;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void edit(T object, String newValue) {
        editField.accept(object, newValue);
    }
}
