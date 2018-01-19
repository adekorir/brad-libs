package brad.data.bean.company;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Person extends Company {

    private final long serialVersionUID = 23L;

    private StringProperty lastName, firstName, otherNames;

    private ObjectProperty<LocalDate> dateOfBirth;

    private ObjectProperty<Gender> gender;

    {
        lastName = new SimpleStringProperty(this, "lastName");
        firstName = new SimpleStringProperty(this, "firstName");
        otherNames = new SimpleStringProperty(this, "otherNames");
        dateOfBirth = new SimpleObjectProperty<>(this, "dateOfBirth", LocalDate.now().minusYears(1L));
        gender = new SimpleObjectProperty<>(this, "gender", Gender.OTHER);
    }

    public Person() {
        super();
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
        updateName();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
        updateName();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getOtherNames() {
        return otherNames.get();
    }

    public void setOtherNames(String otherNames) {
        this.otherNames.set(otherNames);
        updateName();
    }

    public StringProperty otherNamesProperty() {
        return otherNames;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public ObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender.get();
    }

    public void setGender(Gender gender) {
        this.gender.set(gender);
    }

    public ObjectProperty<Gender> genderProperty() {
        return gender;
    }

    private void updateName() {
        final String lName = getLastName() == null ? "" : getLastName().trim();
        final String fName = getFirstName() == null ? "" : getFirstName().trim();
        final String oName = getOtherNames() == null ? "" : getOtherNames().trim();

        setName(lName + ", " + fName + (oName.isEmpty() ? "" : " " + oName));
    }

    public enum Gender {
        MALE("Male"), FEMALE("Female"), OTHER("Other");

        final String genderAsString;

        Gender(String gender) {
            genderAsString = gender;
        }

        @Override
        public String toString() {
            return genderAsString;
        }
    }
}
