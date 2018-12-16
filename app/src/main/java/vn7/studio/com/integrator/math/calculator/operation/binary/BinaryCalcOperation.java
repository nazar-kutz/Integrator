package vn7.studio.com.integrator.math.calculator.operation.binary;

import vn7.studio.com.integrator.math.calculator.operation.CalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.CalcOperationHolder;

public abstract class BinaryCalcOperation extends CalcOperation {
    private String firstArg;
    private String secondArg;

    @Override
    public Double execute() {
        CalcOperation leftOperation = CalcOperationHolder.findOperation(firstArg);
        CalcOperation rightOperation =  CalcOperationHolder.findOperation(secondArg);
        Double leftArgument = leftOperation.execute();
        Double rightArgument = rightOperation.execute();
        return solve(leftArgument, rightArgument);
    }

    protected abstract Double solve(Double leftArgument, Double rightArgument);
}
