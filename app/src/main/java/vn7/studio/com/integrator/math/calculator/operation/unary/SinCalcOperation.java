package vn7.studio.com.integrator.math.calculator.operation.unary;

public class SinCalcOperation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.sin(argument);
    }
}
