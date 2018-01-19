package brad.gui.fx;

import brad.gui.KeypadUpdatable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class VirtualKeypad extends GridPane implements KeypadUpdatable {

    private KeypadUpdatable keypadUpdatable;

    public VirtualKeypad() {
        super();

        this.keypadUpdatable = this::update;

        // keypad
        final char[][] KEYPAD = {
                {'1', '2', '3'}, // row 0
                {'4', '5', '6'}, // row 1
                {'7', '8', '9'}, // row 2
                {'+', '0', '-'}, // row 3
        };

        for (int row = 0; row < KEYPAD.length; row++) {
            for (int col = 0; col < KEYPAD[row].length; col++) {
                final char c = KEYPAD[row][col];

                Button button = new Button("" + c);
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                button.setMinSize(50, 50);
                GridPane.setHgrow(button, Priority.ALWAYS);
                GridPane.setVgrow(button, Priority.ALWAYS);

                button.setOnAction(event -> keypadUpdatable.update(c));

                add(button, col, row);
            }
        }

        setHgap(10);
        setVgap(10);
    }

    @Override
    public void update(char c) {
        System.out.println(c);
    }

    public void setKeypadUpdatable(KeypadUpdatable keypadUpdatable) {
        this.keypadUpdatable = keypadUpdatable;
    }
}
