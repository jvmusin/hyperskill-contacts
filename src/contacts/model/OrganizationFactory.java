package contacts.model;

import contacts.field.FieldEditor;
import contacts.util.IO;

public class OrganizationFactory extends AbstractConsumerFactory<Organization> {
    public OrganizationFactory(IO io) {
        super(io);
    }

    @Override
    public FieldEditor<Organization> getFieldEditor() {
        return Organization.FIELD_EDITOR;
    }

    @Override
    public Organization createEmpty() {
        return new Organization();
    }
}
