package vn7.studio.com.integrator.math.calculator.operation.unary;

public class TanCalcOperation  extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.tan(argument);
    }

    @Override
    public String getRegex() {
        return null;
    }
}