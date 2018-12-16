package vn7.studio.com.integrator.math.calculator.operation.binary;

public class PowerCalcOpearation extends BinaryCalcOperation {

    @Override
    protected Double solve(Double leftArgument, Double rightArgument) {
        return Math.pow(leftArgument, rightArgument);
    }

    @Override
    public String getRegex() {
        return null;
    }
}
