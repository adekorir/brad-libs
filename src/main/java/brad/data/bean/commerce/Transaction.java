package brad.data.bean.commerce;

import brad.data.bean.IndexedBean;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction extends IndexedBean {

    private ObjectProperty<LocalDate> createDate;
    private ObjectProperty<LocalTime> createTime;
    private StringProperty details;

    {
        createDate = new SimpleObjectProperty<>(this, "createDate");
        createTime = new SimpleObjectProperty<>(this, "createTime");
        details = new SimpleStringProperty(this, "details");
    }

    public Transaction() {
        super();
    }

    public LocalDate getCreateDate() {
        return createDate.get();
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate.set(createDate);
    }

    public ObjectProperty<LocalDate> createDateProperty() {
        return createDate;
    }

    public LocalTime getCreateTime() {
        return createTime.get();
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime.set(createTime);
    }

    public ObjectProperty<LocalTime> createTimeProperty() {
        return createTime;
    }

    public String getDetails() {
        return details.get();
    }

    public void setDetails(String details) {
        this.details.set(details);
    }

    public StringProperty detailsProperty() {
        return details;
    }
}
