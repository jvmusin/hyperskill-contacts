package contacts.field;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class FieldEditor<T> {
    private final List<Field<T>> fields;

    private FieldEditor(List<Field<T>> fields) {
        this.fields = fields;
    }

    public List<String> getFieldNames() {
        return fields.stream().map(Field::getShortName).collect(Collectors.toList());
    }

    public void edit(T object, String fieldName, String newValue) {
        for (Field<T> field : fields) {
            if (field.getShortName().equals(fieldName)) {
                field.edit(object, newValue);
            }
        }
    }

    public List<Field<T>> getFields() {
        return fields;
    }

    public static class Builder<T> {
        private final List<Field<T>> fields = new ArrayList<>();

        public FieldEditor.Builder<T> addField(String shortName, String fullName, BiConsumer<T, String> editFieldFunction) {
            fields.add(new AbstractField<>(shortName, fullName, editFieldFunction));
            return this;
        }

        public FieldEditor<T> build() {
            return new FieldEditor<>(fields);
        }
    }
}