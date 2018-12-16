package vn7.studio.com.integrator.math.calculator.operation.unary;


public class FactorialCalcOperation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return factorial(argument);
    }

    private static Double factorial(Double number) {
        if (number == 0 || number == 1) {
            return 1d;
        }
        return number * factorial(number - 1);
    }
}