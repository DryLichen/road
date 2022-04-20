package xml.collection;

import java.util.List;

public class Book {
    private List<String> bname;

    public void setBname(List<String> bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname=" + bname +
                '}';
    }
}
