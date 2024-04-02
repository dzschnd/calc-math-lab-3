package web.calcmathlab3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.function.DoubleUnaryOperator;

import static web.calcmathlab3.Main.*;

public class InputHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource().equals(Main.TO_MAIN_BUTTON)) {
            HEADER_MESSAGE.setText("Выберите действие");
            MAIN_BUTTONS.getChildren().clear();
            TO_CHOOSE_PROPER_INTEGRAL_BUTTON.setText("Решить собственный интеграл");
            TO_CHOOSE_IMPROPER_INTEGRAL_BUTTON.setText("Решить несобственный интеграл");
            MAIN_BUTTONS.getChildren().addAll(TO_CHOOSE_PROPER_INTEGRAL_BUTTON, TO_CHOOSE_IMPROPER_INTEGRAL_BUTTON);
            ROOT_LAYOUT.getChildren().clear();
            ROOT_LAYOUT.getChildren().addAll(HEADER_MESSAGE, MAIN_BUTTONS);
        }
        else if (event.getSource().equals(Main.TO_CHOOSE_PROPER_INTEGRAL_BUTTON)) {
            ROOT_LAYOUT.getChildren().clear();
            HEADER_MESSAGE.setText("Выберите собственный интеграл");
            ROOT_LAYOUT.getChildren().addAll(HEADER_MESSAGE, CHOOSE_PROPER_INTEGRAL_BUTTONS, TO_MAIN_BUTTON);
        }
        else if (event.getSource().equals(Main.TO_CHOOSE_IMPROPER_INTEGRAL_BUTTON)) {
            ROOT_LAYOUT.getChildren().clear();
            HEADER_MESSAGE.setText("Выберите несобственный интеграл");
            ROOT_LAYOUT.getChildren().addAll(HEADER_MESSAGE, CHOOSE_IMPROPER_INTEGRAL_BUTTONS, TO_MAIN_BUTTON);
        }
        else if (event.getSource().equals(Main.CHOOSE_PROPER_INTEGRAL_1_BUTTON) ||
                 event.getSource().equals(Main.CHOOSE_PROPER_INTEGRAL_2_BUTTON) ||
                 event.getSource().equals(Main.CHOOSE_PROPER_INTEGRAL_3_BUTTON) ||
                 event.getSource().equals(Main.CHOOSE_IMPROPER_INTEGRAL_1_BUTTON) ||
                 event.getSource().equals(Main.CHOOSE_IMPROPER_INTEGRAL_2_BUTTON)) {
            ROOT_LAYOUT.getChildren().clear();
            RESPONSE_MESSAGE.setText("");
            LEFT_BORDER_INPUT.setText("");
            RIGHT_BORDER_INPUT.setText("");
            ACCURACY_INPUT.setText("");
            LEFT_BORDER_INPUT.setPromptText("Нижняя граница");
            RIGHT_BORDER_INPUT.setPromptText("Верхняя граница");
            ACCURACY_INPUT.setPromptText("Точность");
            HEADER_MESSAGE.setText("Выберите метод и границы интегрирования");
            ROOT_LAYOUT.getChildren().addAll(HEADER_MESSAGE, LEFT_BORDER_INPUT, RIGHT_BORDER_INPUT, ACCURACY_INPUT, METHOD_INPUT, RESPONSE_MESSAGE);
            if (event.getSource().equals(Main.CHOOSE_PROPER_INTEGRAL_1_BUTTON))
                ROOT_LAYOUT.getChildren().addAll(SOLVE_PROPER_INTEGRAL_1_BUTTON, TO_MAIN_BUTTON);
            else if (event.getSource().equals(Main.CHOOSE_PROPER_INTEGRAL_2_BUTTON))
                ROOT_LAYOUT.getChildren().addAll(SOLVE_PROPER_INTEGRAL_2_BUTTON, TO_MAIN_BUTTON);
            else if (event.getSource().equals(Main.CHOOSE_PROPER_INTEGRAL_3_BUTTON))
                ROOT_LAYOUT.getChildren().addAll(SOLVE_PROPER_INTEGRAL_3_BUTTON, TO_MAIN_BUTTON);
            else if (event.getSource().equals(Main.CHOOSE_IMPROPER_INTEGRAL_1_BUTTON))
                ROOT_LAYOUT.getChildren().addAll(SOLVE_IMPROPER_INTEGRAL_1_BUTTON, TO_MAIN_BUTTON);
            else if (event.getSource().equals(Main.CHOOSE_IMPROPER_INTEGRAL_2_BUTTON))
                ROOT_LAYOUT.getChildren().addAll(SOLVE_IMPROPER_INTEGRAL_2_BUTTON, TO_MAIN_BUTTON);
        }
        else if (event.getSource().equals(SOLVE_PROPER_INTEGRAL_1_BUTTON)) {
            solveProperIntegral(IntegralSolver::f1);
        }
        else if (event.getSource().equals(SOLVE_PROPER_INTEGRAL_2_BUTTON)) {
            solveProperIntegral(IntegralSolver::f2);
        }
        else if (event.getSource().equals(SOLVE_PROPER_INTEGRAL_3_BUTTON)) {
            solveProperIntegral(IntegralSolver::f3);
        }
        else if (event.getSource().equals(SOLVE_IMPROPER_INTEGRAL_1_BUTTON)) {
            solveProperIntegral(IntegralSolver::f4);
        }
        else if (event.getSource().equals(SOLVE_IMPROPER_INTEGRAL_2_BUTTON)) {
            solveProperIntegral(IntegralSolver::f5);
        }
    }
    private static void solveProperIntegral(DoubleUnaryOperator f) {
        try {
            double leftBorder = Double.parseDouble(LEFT_BORDER_INPUT.getText());
            double rightBorder = Double.parseDouble(RIGHT_BORDER_INPUT.getText());
            double accuracy = Double.parseDouble(ACCURACY_INPUT.getText());
            if (accuracy <= 0) throw new NumberFormatException();
            String method = METHOD_INPUT.getValue().toString();
            switch (method) {
                case "Метод левых прямоугольников":
                    RESPONSE_MESSAGE.setText(Double.toString(IntegralSolver.leftRectanglesSolve(f, leftBorder, rightBorder, accuracy)));
                    break;
                case "Метод правых прямоугольников":
                    RESPONSE_MESSAGE.setText(Double.toString(IntegralSolver.rightRectanglesSolve(f, leftBorder, rightBorder, accuracy)));
                    break;
                case "Метод средних прямоугольников":
                    RESPONSE_MESSAGE.setText(Double.toString(IntegralSolver.middleRectanglesSolve(f, leftBorder, rightBorder, accuracy)));
                    break;
                case "Метод трапеций":
                    RESPONSE_MESSAGE.setText(Double.toString(IntegralSolver.trapezoidSolve(f, leftBorder, rightBorder, accuracy)));
                    break;
                case "Метод Симпсона":
                    RESPONSE_MESSAGE.setText(Double.toString(IntegralSolver.simpsonSolve(f, leftBorder, rightBorder, accuracy)));
                    break;
            }
        } catch (NumberFormatException e) {
            RESPONSE_MESSAGE.setText("Численные значения введены некорректно");
        } catch (NullPointerException e) {
            RESPONSE_MESSAGE.setText("Метод не выбран");
        } catch (ConvergenceException e) {
            RESPONSE_MESSAGE.setText(e.getMessage());
        }
    }
}