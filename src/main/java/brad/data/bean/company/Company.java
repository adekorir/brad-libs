package brad.data.bean.company;

import brad.data.bean.IndexedBean;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Company extends IndexedBean {

    private final long serialVersionUID = 12L;

    private StringProperty name, notes;

    private BooleanProperty active;

    {
        name = new SimpleStringProperty(this, "name");
        notes = new SimpleStringProperty(this, "notes");

        active = new SimpleBooleanProperty(this, "active");
    }

    public Company() {
        super();
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public boolean isActive() {
        return active.get();
    }

    public void setActive(boolean active) {
        this.active.set(active);
    }

    public BooleanProperty activeProperty() {
        return active;
    }

    @Override
    public String toString() {
        return getName();
    }
}
