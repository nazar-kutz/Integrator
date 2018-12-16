package vn7.studio.com.integrator.math.calculator.operation.unary;

public class CtanCalcOperation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.cos(argument) / Math.sin(argument);
    }

    @Override
    public String getRegex() {
        return null;
    }
}