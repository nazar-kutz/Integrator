package vn7.studio.com.integrator.math.calculator.operation.binary;

public class AddCalcOperation extends BinaryCalcOperation {

    @Override
    protected Double solve(Double leftArgument, Double rightArgument) {
        return leftArgument + rightArgument;
    }
}
