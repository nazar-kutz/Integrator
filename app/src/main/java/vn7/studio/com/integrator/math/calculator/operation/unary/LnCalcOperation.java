package vn7.studio.com.integrator.math.calculator.operation.unary;

public class LnCalcOperation extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.log(argument);
    }

    @Override
    public String getRegex() {
        return null;
    }
}