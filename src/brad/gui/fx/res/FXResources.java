package brad.gui.fx.res;

public class FXResources {

    private static FXResources ourInstance = new FXResources();
    private Theme theme;

    private FXResources() {
        super();

        theme = Theme.DARK;
    }

    public static FXResources getInstance() {
        return ourInstance;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
