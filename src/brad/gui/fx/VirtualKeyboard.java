package brad.gui.fx;

import brad.gui.CharUpdatable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class VirtualKeyboard extends HBox implements CharUpdatable {

    private VBox root;
    private boolean shiftDown, capsOn;
    private CharUpdatable updatable;

    public VirtualKeyboard() {
        super(10);

        this.root = new VBox(10);
        this.updatable = this::update;

        capsOn = shiftDown = false;

        getChildren().addAll(new HSpacer(), root, new HSpacer());
        updateKeyboard();
    }

    private void updateKeyboard() {
        root.getChildren().clear();
        final String[][] NORMAL_KEYBOARD = {
                {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "BACKSPACE"},
                {"TAB", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "\\"},
                {"CAPS LOCK", "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "ENTER"},
                {"SHIFT", "z", "x", "c", "v", "b", "n", "m", ",", ".", "/", "SHIFT"},
                {"SPACE BAR"}
        };

        final String[][] NORMAL_SHIFT_KEYBOARD = {
                {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "BACKSPACE"},
                {"TAB", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "{", "}", "|"},
                {"CAPS LOCK", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "ENTER"},
                {"SHIFT", "Z", "X", "C", "V", "B", "N", "M", "<", ">", "?", "SHIFT"},
                {"SPACE BAR"}
        };

        final String[][] CAPS_KEYBOARD = {
                {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "BACKSPACE"},
                {"TAB", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"},
                {"CAPS LOCK", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "ENTER"},
                {"SHIFT", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "SHIFT"},
                {"SPACE BAR"}
        };

        final String[][] CAPS_SHIFT_KEYBOARD = {
                {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "BACKSPACE"},
                {"TAB", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "{", "}", "|"},
                {"CAPS LOCK", "a", "s", "d", "f", "g", "h", "j", "k", "l", ":", "\"", "ENTER"},
                {"SHIFT", "z", "x", "c", "v", "b", "n", "m", "<", ">", "?", "SHIFT"},
                {"SPACE BAR"}
        };

        String[][] keyboard;
        if (capsOn) {
            if (shiftDown)
                keyboard = CAPS_SHIFT_KEYBOARD;
            else
                keyboard = CAPS_KEYBOARD;
        } else {
            if (shiftDown)
                keyboard = NORMAL_SHIFT_KEYBOARD;
            else
                keyboard = NORMAL_KEYBOARD;
        }

        for (String row[] : keyboard) {

            HBox hBox = new HBox(10);

            for (String btnText : row) {

                ButtonBase button = new Button(btnText);

                // set button dimensions
                switch (btnText) {
                    case "BACKSPACE":
                    case "SHIFT":
                    case "TAB":
                    case "ENTER":
                    case "CAPS LOCK":
                    case "SPACE BAR":
                        button.setMinSize(50 * 2.5, 50);
                        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                        HBox.setHgrow(button, Priority.ALWAYS);
                        break;
                    default:
                        button.setMinSize(50, 50);
                }

                // set button actions
                button.setOnAction(event -> {
                    switch (btnText) {
                        case "BACKSPACE":
                            updatable.update('\r');
                            break;
                        case "ENTER":
                            updatable.update('\n');
                            break;
                        case "TAB":
                            updatable.update('\t');
                            break;
                        case "SHIFT":
                            shiftDown = !shiftDown; // toggle shift
                            updateKeyboard();
                            break;
                        case "CAPS LOCK":
                            capsOn = !capsOn;   // toggle caps
                            updateKeyboard();
                            break;
                        case "SPACE BAR":
                            updatable.update(' ');
                            break;
                        default: {
                            updatable.update(btnText.charAt(0));
                            if (shiftDown) {
                                shiftDown = false;
                                updateKeyboard();
                            }
                        }
                    }
                });

                if (btnText.equals("SPACE BAR")) {
                    hBox.getChildren().addAll(new HSpacer(), button, new HSpacer());
                } else {
                    hBox.getChildren().add(button);
                }
            }

            root.getChildren().add(hBox);
        }
    }

    @Override
    public void update(char c) {
        System.out.println(c);
    }

    public void setUpdatable(CharUpdatable updatable) {
        this.updatable = updatable;
    }
}
