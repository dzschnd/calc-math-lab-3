package web.calcmathlab3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    static final Label HEADER_MESSAGE = new Label();
    static final Button TO_MAIN_BUTTON = new Button("На главную");
    static final Button TO_CHOOSE_PROPER_INTEGRAL_BUTTON = new Button("Выбрать собственный интеграл");
    static final Button TO_CHOOSE_IMPROPER_INTEGRAL_BUTTON = new Button("Выбрать несобственный интеграл");
    static final HBox MAIN_BUTTONS = new HBox(TO_CHOOSE_PROPER_INTEGRAL_BUTTON, TO_CHOOSE_IMPROPER_INTEGRAL_BUTTON);
    static final Button CHOOSE_PROPER_INTEGRAL_1_BUTTON = new Button("2x^3 - 9x^2 - 7x + 11");
    static final Button CHOOSE_PROPER_INTEGRAL_2_BUTTON = new Button("x^3 - 3x^2 + 7x - 10");
    static final Button CHOOSE_PROPER_INTEGRAL_3_BUTTON = new Button("-2x^3 - 5x^2 - 3x - 12");
    static final VBox CHOOSE_PROPER_INTEGRAL_BUTTONS = new VBox(CHOOSE_PROPER_INTEGRAL_1_BUTTON, CHOOSE_PROPER_INTEGRAL_2_BUTTON, CHOOSE_PROPER_INTEGRAL_3_BUTTON);
    static final Button CHOOSE_IMPROPER_INTEGRAL_1_BUTTON = new Button("-2/sqrt(x)");
    static final Button CHOOSE_IMPROPER_INTEGRAL_2_BUTTON = new Button("1/x^2");
    static final VBox CHOOSE_IMPROPER_INTEGRAL_BUTTONS = new VBox(CHOOSE_IMPROPER_INTEGRAL_1_BUTTON, CHOOSE_IMPROPER_INTEGRAL_2_BUTTON);
    static final TextField LEFT_BORDER_INPUT = new TextField();
    static final TextField RIGHT_BORDER_INPUT = new TextField();
    static final TextField ACCURACY_INPUT = new TextField();

    static final ObservableList<String> METHOD_OPTIONS = FXCollections.observableArrayList(
                    "Метод левых прямоугольников",
                        "Метод правых прямоугольников",
                        "Метод средних прямоугольников",
                        "Метод трапеций",
                        "Метод Симпсона"
            );
    static final ComboBox METHOD_INPUT = new ComboBox(METHOD_OPTIONS);
    static final Label RESPONSE_MESSAGE = new Label();
    static final Button SOLVE_PROPER_INTEGRAL_1_BUTTON = new Button("Решить");
    static final Button SOLVE_PROPER_INTEGRAL_2_BUTTON = new Button("Решить");
    static final Button SOLVE_PROPER_INTEGRAL_3_BUTTON = new Button("Решить");
    static final Button SOLVE_IMPROPER_INTEGRAL_1_BUTTON = new Button("Решить");
    static final Button SOLVE_IMPROPER_INTEGRAL_2_BUTTON = new Button("Решить");
    static final VBox ROOT_LAYOUT = new VBox();

    @Override
    public void start(Stage stage) {
        InputHandler inputHandler = new InputHandler();

        TO_MAIN_BUTTON.setOnAction(inputHandler);
        TO_CHOOSE_PROPER_INTEGRAL_BUTTON.setOnAction(inputHandler);
        TO_CHOOSE_IMPROPER_INTEGRAL_BUTTON.setOnAction(inputHandler);
        CHOOSE_PROPER_INTEGRAL_1_BUTTON.setOnAction(inputHandler);
        CHOOSE_PROPER_INTEGRAL_2_BUTTON.setOnAction(inputHandler);
        CHOOSE_PROPER_INTEGRAL_3_BUTTON.setOnAction(inputHandler);
        CHOOSE_PROPER_INTEGRAL_2_BUTTON.setOnAction(inputHandler);
        CHOOSE_PROPER_INTEGRAL_3_BUTTON.setOnAction(inputHandler);
        CHOOSE_IMPROPER_INTEGRAL_1_BUTTON.setOnAction(inputHandler);
        CHOOSE_IMPROPER_INTEGRAL_2_BUTTON.setOnAction(inputHandler);
        SOLVE_PROPER_INTEGRAL_1_BUTTON.setOnAction(inputHandler);
        SOLVE_PROPER_INTEGRAL_2_BUTTON.setOnAction(inputHandler);
        SOLVE_PROPER_INTEGRAL_3_BUTTON.setOnAction(inputHandler);
        SOLVE_IMPROPER_INTEGRAL_1_BUTTON.setOnAction(inputHandler);
        SOLVE_IMPROPER_INTEGRAL_2_BUTTON.setOnAction(inputHandler);

        VBox.setMargin(HEADER_MESSAGE, new Insets(5));

        HBox.setMargin(TO_CHOOSE_PROPER_INTEGRAL_BUTTON, new Insets(5));
        HBox.setMargin(TO_CHOOSE_IMPROPER_INTEGRAL_BUTTON, new Insets(5));

        VBox.setMargin(CHOOSE_PROPER_INTEGRAL_1_BUTTON, new Insets(5));
        VBox.setMargin(CHOOSE_PROPER_INTEGRAL_2_BUTTON, new Insets(5));
        VBox.setMargin(CHOOSE_PROPER_INTEGRAL_3_BUTTON, new Insets(5));
        VBox.setMargin(CHOOSE_IMPROPER_INTEGRAL_1_BUTTON, new Insets(5));
        VBox.setMargin(CHOOSE_IMPROPER_INTEGRAL_2_BUTTON, new Insets(5));

        VBox.setMargin(LEFT_BORDER_INPUT, new Insets(5));
        VBox.setMargin(RIGHT_BORDER_INPUT, new Insets(5));
        VBox.setMargin(ACCURACY_INPUT, new Insets(5));
        VBox.setMargin(METHOD_INPUT, new Insets(5));

        VBox.setMargin(TO_MAIN_BUTTON, new Insets(20));

        HEADER_MESSAGE.setText("Выберите действие");
        HEADER_MESSAGE.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 24");
        RESPONSE_MESSAGE.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 16");
        LEFT_BORDER_INPUT.setStyle("-fx-max-width: 175;");
        RIGHT_BORDER_INPUT.setStyle("-fx-max-width: 175;");
        ACCURACY_INPUT.setStyle("-fx-max-width: 175;");
        SOLVE_PROPER_INTEGRAL_1_BUTTON.setStyle("-fx-max-width: 175;");
        SOLVE_PROPER_INTEGRAL_2_BUTTON.setStyle("-fx-max-width: 175;");
        SOLVE_PROPER_INTEGRAL_3_BUTTON.setStyle("-fx-max-width: 175;");
        SOLVE_IMPROPER_INTEGRAL_1_BUTTON.setStyle("-fx-max-width: 175;");
        SOLVE_IMPROPER_INTEGRAL_2_BUTTON.setStyle("-fx-max-width: 175;");

        METHOD_INPUT.setPromptText("Выберите метод");

        MAIN_BUTTONS.setAlignment(Pos.CENTER);
        CHOOSE_PROPER_INTEGRAL_BUTTONS.setAlignment(Pos.CENTER);
        CHOOSE_IMPROPER_INTEGRAL_BUTTONS.setAlignment(Pos.CENTER);
        ROOT_LAYOUT.setAlignment(Pos.TOP_CENTER);

        ROOT_LAYOUT.setStyle("-fx-background-color: #2d2d2d;");
        ROOT_LAYOUT.getChildren().addAll(HEADER_MESSAGE, MAIN_BUTTONS);

        Scene scene = new Scene(ROOT_LAYOUT, 600, 360);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Вычмат...");
        stage.show();
    }
}