package brad.gui.fx;

import brad.gui.fx.res.FXResources;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.PrintWriter;
import java.io.StringWriter;

public class SystemDialogs {

    private static boolean queryResponse;

    public static void showException(String title, Throwable ex) {
        final Label lblMessage = new Label(title);
        lblMessage.setFont(Font.font(16));

        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();

        final Stage stage = new Stage(StageStyle.UNIFIED);

        final TextArea textArea = new TextArea(exceptionAsString);
        textArea.setEditable(false);

        TitledPane titledPane = new TitledPane("More Details", textArea);
        titledPane.setCollapsible(false);

        final Button button = new Button("OK");
        button.setOnAction(event -> stage.close());
        button.setMinWidth(80);

        Region hSpacer1 = new Region();
        HBox.setHgrow(hSpacer1, Priority.ALWAYS);
        Region hSpacer2 = new Region();
        HBox.setHgrow(hSpacer2, Priority.ALWAYS);

        final HBox actionPane = new HBox(10, hSpacer1, button, hSpacer2);
        actionPane.setPadding(new Insets(10, 0, 0, 0));

        final BorderPane root = new BorderPane(textArea);
        root.setTop(new HBox(10, lblMessage));
        root.setBottom(actionPane);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);
        try {
            scene.getStylesheets().addAll(FXResources.getInstance().getTheme().getResourceFile());
        } catch (NullPointerException e) {
            scene.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        }

        stage.setTitle("Exception: " + ex.toString());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static boolean showQuery(String title, String message) {
        queryResponse = false;

        Button btnYes, btnNo;
        btnNo = new Button("No");
        btnYes = new Button("Yes");
        final Stage stage = new Stage(StageStyle.UNIFIED);

        final Label label = new Label();
        label.setFont(Font.font(14));

        btnNo.setMinWidth(80);
        btnNo.setOnAction(event -> {
            queryResponse = false;
            stage.close();
        });
        btnNo.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                btnNo.fire();
        });

        btnYes.setMinWidth(80);
        btnYes.setOnAction(event -> {
            queryResponse = true;
            stage.close();
        });
        btnYes.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                btnYes.fire();
        });

        label.setText(message);

        btnYes.requestFocus();

        HBox actionBar = new HBox(10, new HSpacer(), btnYes, btnNo);
        actionBar.setPadding(new Insets(10, 0, 0, 0));

        HBox centerPane;
        try {
            ImageView imageView = new ImageView(new Image(FXResources.class.getResource("dialog_alert.png").toString()));
            centerPane = new HBox(5, imageView, label);
            centerPane.setAlignment(Pos.CENTER);
        } catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
            centerPane = new HBox(5, label);
            ex.printStackTrace();
        }

        BorderPane root = new BorderPane(centerPane);
        root.setBottom(actionBar);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);
        try {
            scene.getStylesheets().addAll(FXResources.getInstance().getTheme().getResourceFile());
        } catch (NullPointerException e) {
            scene.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        }

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE)
                stage.close();
        });

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.showAndWait();

        return queryResponse;
    }

    public static void showMessage(MessageType messageType, String title, String message) {
        final Button button = new Button("OK");
        final Stage stage = new Stage(StageStyle.UNIFIED);

        final Label label = new Label();
        label.setFont(Font.font(14));

        button.setMinWidth(80);
        button.setOnAction(event -> stage.close());
        button.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                button.fire();
        });

        label.setText(message);
        button.requestFocus();

        HBox actionBar = new HBox(10, new HSpacer(), button, new HSpacer());
        actionBar.setPadding(new Insets(10, 0, 0, 0));

        ImageView imageView;
        switch (messageType) {
            case ALERT:
                imageView = new ImageView(FXResources.class.getResource("dialog_alert.png").toString());
                break;
            case WARNING:
                imageView = new ImageView(FXResources.class.getResource("dialog_warn.png").toString());
                break;
            case INFO:
            default:
                imageView = new ImageView(FXResources.class.getResource("dialog_info.png").toString());
                break;
        }

        HBox centerPane = new HBox(5, imageView, label);
        centerPane.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane(centerPane);
        root.setBottom(actionBar);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);
        try {
            scene.getStylesheets().addAll(FXResources.getInstance().getTheme().getResourceFile());
        } catch (NullPointerException e) {
            scene.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        }

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE)
                stage.close();
            if (event.getCode() == KeyCode.ENTER)
                button.fire();
        });

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public enum MessageType {
        WARNING, INFO, ALERT
    }
}
