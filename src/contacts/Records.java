package contacts;

import contacts.model.Consumer;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Records extends AbstractList<Consumer> implements Serializable {
    private final List<Consumer> records = new ArrayList<>();

    @Override
    public boolean add(Consumer consumer) {
        return records.add(consumer);
    }

    public Consumer remove(int index) {
        return records.remove(index);
    }

    @Override
    public Consumer get(int i) {
        return records.get(i);
    }

    @Override
    public Iterator<Consumer> iterator() {
        return records.iterator();
    }

    @Override
    public int size() {
        return records.size();
    }

    //@formatter:off
    public Records filter(String query) {
        Pattern p = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        return records.stream()
                .filter(c -> p.matcher(c.getInfo()).find())
                .reduce(new Records(),
                        (r, c) -> { r.add(c); return r; },
                        (a, b) -> { a.addAll(b); return a; });
    }
    //@formatter:on
}
