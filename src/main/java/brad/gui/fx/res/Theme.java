package brad.gui.fx.res;

public enum Theme {

    DARK("dark-theme.css"), LIGHT("light-theme.css");

    private String resourceFile;

    Theme(String resourceFile) {
        this.resourceFile = resourceFile;
    }

    public String getResourceFile() {
        return Theme.class.getResource(resourceFile).toExternalForm();
    }
}
