package brad.data.bean.login;

import brad.data.bean.IndexedBean;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User extends IndexedBean {

    private StringProperty username, password, displayName;
    private BooleanProperty active;

    public User() {
        super();

        username = new SimpleStringProperty(this, "username");
        password = new SimpleStringProperty(this, "password");
        displayName = new SimpleStringProperty(this, "displayName");

        active = new SimpleBooleanProperty(this, "active");
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getDisplayName() {
        return displayName.get();
    }

    public void setDisplayName(String displayName) {
        this.displayName.set(displayName);
    }

    public StringProperty displayNameProperty() {
        return displayName;
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
        return getUsername();
    }
}
