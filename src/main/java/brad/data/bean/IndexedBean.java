package brad.data.bean;

import brad.data.Bean;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class IndexedBean implements Bean {

    private LongProperty id;

    {
        id = new SimpleLongProperty(this, "id");
    }

    public IndexedBean() {
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
