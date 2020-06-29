package contacts.field;

public interface Field<T> {
    String getShortName();

    String getFullName();

    void edit(T object, String newValue);
}