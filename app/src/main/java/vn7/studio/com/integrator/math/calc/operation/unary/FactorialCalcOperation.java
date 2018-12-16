package vn7.studio.com.integrator.math.calc.operation.unary;


public class FactorialCalcOperation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double arg) {
        return factorial(arg);
    }

    private static Double factorial(Double number) {
        if (number == 0 || number == 1) {
            return 1d;
        }
        return number * factorial(number - 1);
    }
}