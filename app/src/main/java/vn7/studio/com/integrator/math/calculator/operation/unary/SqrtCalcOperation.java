package vn7.studio.com.integrator.math.calculator.operation.unary;

public class SqrtCalcOperation  extends UnaryCalcOperation {

    @Override
    protected Double solve(Double argument) {
        return Math.sqrt(argument);
    }

    @Override
    public String getRegex() {
        return null;
    }
}
