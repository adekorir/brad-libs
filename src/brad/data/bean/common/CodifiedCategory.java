package brad.data.bean.common;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CodifiedCategory extends Category {

    private StringProperty code;

    {
        this.code = new SimpleStringProperty(this, "id");
    }

    public CodifiedCategory() {
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
