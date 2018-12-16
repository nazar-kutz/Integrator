package vn7.studio.com.integrator.math.calculator.operation.unary;

public class ExpCalcOperation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.exp(argument);
    }

    @Override
    public String getRegex() {
        return null;
    }
}
