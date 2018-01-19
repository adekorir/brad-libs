package brad.data.bean.address;

import brad.data.bean.IndexedBean;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContactType extends IndexedBean {

    private StringProperty description, notes;

    {
        description = new SimpleStringProperty(this, "description");
        notes = new SimpleStringProperty(this, "notes");
    }

    public ContactType() {
        super();
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
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

    @Override
    public String toString() {
        return getDescription();
    }
}
