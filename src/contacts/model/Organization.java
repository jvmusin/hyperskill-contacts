package contacts.model;

import contacts.field.FieldEditor;

import java.util.StringJoiner;

public class Organization extends Consumer {
    public static final FieldEditor<Organization> FIELD_EDITOR = new FieldEditor.Builder<Organization>()
            .addField("name", "organization name", Organization::setName)
            .addField("address", "address", Organization::setAddress)
            .addField("number", "number", Organization::setNumber)
            .build();

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        updated();
    }

    @Override
    public String getInfo() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add(formatField("Organization name", getName()));
        sj.add(formatField("Address", getAddress()));
        sj.add(super.getInfo());
        return sj.toString();
    }

    @Override
    public void editField(String fieldName, String newValue) {
        FIELD_EDITOR.edit(this, fieldName, newValue);
    }

    @Override
    public FieldEditor<Organization> getFieldEditor() {
        return FIELD_EDITOR;
    }

    @Override
    public String toString() {
        return getName();
    }
}
