package brad.data.bean.common;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class IndexedCategory extends Category {

    private LongProperty id;

    {
        id = new SimpleLongProperty(this, "id");
    }

    public IndexedCategory() {
        super();
    }

    public long getId() {
        return id.get();
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public LongProperty idProperty() {
        return id;
    }
}
