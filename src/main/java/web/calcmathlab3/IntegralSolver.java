package web.calcmathlab3;

import java.util.function.DoubleUnaryOperator;

import static java.lang.Math.*;

public class IntegralSolver {
    private static final int MAX_ITERATIONS = 100000;
    static double f1(double x) {return 2*pow(x, 3) - 9*pow(x, 2) - 7*x + 11;}

    static double f2(double x) {return pow(x, 3) - 3*pow(x, 2) + 7*x - 10;}

    static double f3(double x) {return -2 * pow(x, 3) - 5 * pow(x, 2) - 3 * x - 12;}
    static double f4(double x) {return -2 / sqrt(x);}
    static double f5(double x) {return 1 / pow(x, 2);}

    public static double leftRectanglesSolve(DoubleUnaryOperator f, double a, double b, double accuracy) throws ConvergenceException {
        double leftBorder = min(a, b);
        double rightBorder = max(a, b);
        double step = (rightBorder - leftBorder) / 4;
        double result1 = 0;
        double result2 = 0;
        double x;
        int iterationCount = 0;
        if (Double.isInfinite(f.applyAsDouble(leftBorder)) && Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точки разрыва на границах интегрирования");
        if (Double.isInfinite(f.applyAsDouble(leftBorder)))
            throw new ConvergenceException("Точка разрыва на левой границе интегрирования");
        if (Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точка разрыва на правой границе интегрирования");
        do {
            x = leftBorder;
            while (x < rightBorder) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result1 += f.applyAsDouble(x);
                x += step;
            }
            result1 = step * result1;
            step /= 2;
            x = leftBorder;
            while (x < rightBorder) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result2 += f.applyAsDouble(x);
                x += step;
            }
            result2 = step * result2;
            iterationCount++;
            if (iterationCount == MAX_ITERATIONS)
                throw new ConvergenceException("Интеграл не существует");
        } while (abs(result2 - result1)/3 > accuracy);
        if (Double.isInfinite(result2) || Double.isNaN(result2))
            throw new ConvergenceException("Точка разрыва на отрезке интегрирования");
        return a <= b ? result2 : -1 * result2;
    }
    public static double rightRectanglesSolve(DoubleUnaryOperator f, double a, double b, double accuracy) throws ConvergenceException {
        double leftBorder = min(a, b);
        double rightBorder = max(a, b);
        double step = (rightBorder - leftBorder) / 4;
        double result1 = 0;
        double result2 = 0;
        double x;
        int iterationCount = 0;
        if (Double.isInfinite(f.applyAsDouble(leftBorder)) && Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точки разрыва на границах интегрирования");
        if (Double.isInfinite(f.applyAsDouble(leftBorder)))
            throw new ConvergenceException("Точка разрыва на левой границе интегрирования");
        if (Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точка разрыва на правой границе интегрирования");
        do {
            x = leftBorder + step;
            while (x < rightBorder + step) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result1 += f.applyAsDouble(x);
                x += step;
            }
            result1 = step * result1;
            step /= 2;
            x = leftBorder + step;
            while (x < rightBorder + step) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result2 += f.applyAsDouble(x);
                x += step;
            }
            result2 = step * result2;
            iterationCount++;
            if (iterationCount == MAX_ITERATIONS)
                throw new ConvergenceException("Интеграл не существует");
        } while (abs(result2 - result1)/3 > accuracy);
        if (Double.isInfinite(result2) || Double.isNaN(result2))
            throw new ConvergenceException("Точка разрыва на отрезке интегрирования");
        return a <= b ? result2 : -1 * result2;
    }
    public static double middleRectanglesSolve(DoubleUnaryOperator f, double a, double b, double accuracy) throws ConvergenceException {
        double leftBorder = min(a, b);
        double rightBorder = max(a, b);
        double step = (rightBorder - leftBorder) / 4;
        double result1 = 0;
        double result2 = 0;
        double x;
        int iterationCount = 0;
        if (Double.isInfinite(f.applyAsDouble(leftBorder)) && Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точки разрыва на границах интегрирования");
        if (Double.isInfinite(f.applyAsDouble(leftBorder)))
            throw new ConvergenceException("Точка разрыва на левой границе интегрирования");
        if (Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точка разрыва на правой границе интегрирования");
        do {
            x = leftBorder + step/2;
            while (x < rightBorder + step/2) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result1 += f.applyAsDouble(x);
                x += step;
            }
            result1 = step * result1;
            step /= 2;
            x = leftBorder + step/2;
            while (x < rightBorder + step/2) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result2 += f.applyAsDouble(x);
                x += step;
            }
            result2 = step * result2;
            iterationCount++;
            if (iterationCount == MAX_ITERATIONS)
                throw new ConvergenceException("Интеграл не существует");
        } while (abs(result2 - result1)/3 > accuracy);
        if (Double.isInfinite(result2) || Double.isNaN(result2))
            throw new ConvergenceException("Точка разрыва на отрезке интегрирования");
        return a <= b ? result2 : -1 * result2;
    }
    public static double trapezoidSolve(DoubleUnaryOperator f, double a, double b, double accuracy) throws ConvergenceException {
        double leftBorder = min(a, b);
        double rightBorder = max(a, b);
        double step = (rightBorder - leftBorder) / 4;
        double result1 = 0;
        double result2 = 0;
        double x;
        int iterationCount = 0;
        if (Double.isInfinite(f.applyAsDouble(leftBorder)) && Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точки разрыва на границах интегрирования");
        if (Double.isInfinite(f.applyAsDouble(leftBorder)))
            throw new ConvergenceException("Точка разрыва на левой границе интегрирования");
        if (Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точка разрыва на правой границе интегрирования");
        do {
            result1 += f.applyAsDouble(leftBorder);
            result1 += f.applyAsDouble(rightBorder);
            x = leftBorder + step;
            while (x < rightBorder) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result1 += 2 * f.applyAsDouble(x);
                x += step;
            }
            result1 = step/2 * result1;
            step /= 2;
            result2 += f.applyAsDouble(leftBorder);
            result2 += f.applyAsDouble(rightBorder);
            x = leftBorder + step;
            while (x < rightBorder) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result2 += 2 * f.applyAsDouble(x);
                x += step;
            }
            result2 = step/2 * result2;
            iterationCount++;
            if (iterationCount == MAX_ITERATIONS)
                throw new ConvergenceException("Интеграл не существует");
        } while (abs(result2 - result1)/3 > accuracy);
        if (Double.isInfinite(result2) || Double.isNaN(result2))
            throw new ConvergenceException("Точка разрыва на отрезке интегрирования");
        return a <= b ? result2 : -1 * result2;
    }
    public static double simpsonSolve(DoubleUnaryOperator f, double a, double b, double accuracy) throws ConvergenceException{
        double leftBorder = min(a, b);
        double rightBorder = max(a, b);
        double step = (rightBorder - leftBorder) / 4;
        double result1 = 0;
        double result2 = 0;
        double x;
        int iterationCount = 0;
        if (Double.isInfinite(f.applyAsDouble(leftBorder)) && Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точки разрыва на границах интегрирования");
        if (Double.isInfinite(f.applyAsDouble(leftBorder)))
            throw new ConvergenceException("Точка разрыва на левой границе интегрирования");
        if (Double.isInfinite(f.applyAsDouble(rightBorder)))
            throw new ConvergenceException("Точка разрыва на правой границе интегрирования");
        do {
            result1 += f.applyAsDouble(leftBorder);
            result1 += f.applyAsDouble(rightBorder);
            x = leftBorder + step;
            while (x <= rightBorder - step) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result1 += 4 * f.applyAsDouble(x);
                x += 2*step;
            }
            x = leftBorder + 2 * step;
            while (x <= rightBorder - 2*step) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result1 += 2 * f.applyAsDouble(x);
                x += 2*step;
            }
            result1 = step/3 * result1;

            step /= 2;
            result2 += f.applyAsDouble(leftBorder);
            result2 += f.applyAsDouble(rightBorder);
            x = leftBorder + step;
            while (x <= rightBorder - step) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result2 += 4 * f.applyAsDouble(x);
                x += 2*step;
            }
            x = leftBorder + 2 * step;
            while (x <= rightBorder - 2*step) {
                if (!(Double.isNaN(f.applyAsDouble(x)) || Double.isInfinite(f.applyAsDouble(x))))
                    result2 += 2 * f.applyAsDouble(x);
                x += 2*step;
            }
            result2 = step/3 * result2;
            iterationCount++;
            if (iterationCount == MAX_ITERATIONS)
                throw new ConvergenceException("Интеграл не существует");
        } while (abs(result2 - result1)/15 > accuracy);
        if (Double.isInfinite(result2) || Double.isNaN(result2))
            throw new ConvergenceException("Точка разрыва на отрезке интегрирования");
        return a <= b ? result2 : -1 * result2;
    }
}
