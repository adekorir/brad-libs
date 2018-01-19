package brad.data.bean;

import brad.data.Bean;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CodifiedBean implements Bean {

    private StringProperty code;

    {
        this.code = new SimpleStringProperty(this, "id");
    }

    public CodifiedBean() {
        super();
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public StringProperty codeProperty() {
        return code;
    }
}
