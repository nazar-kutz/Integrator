package vn7.studio.com.integrator.math.calculator.operation.binary;

import vn7.studio.com.integrator.math.calculator.operation.CalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.CalcOperationHolder;

public abstract class BinaryCalcOperation extends CalcOperation {
    private String firstArg;

    public String getFirstArg() {
        return firstArg;
    }

    public void setFirstArg(String firstArg) {
        this.firstArg = firstArg;
    }

    public String getSecondArg() {
        return secondArg;
    }

    public void setSecondArg(String secondArg) {
        this.secondArg = secondArg;
    }

    private String secondArg;

    @Override
    public Double execute() {
        CalcOperationHolder holder = new CalcOperationHolder();
        CalcOperation leftOperation = holder.findOperation(firstArg);
        CalcOperation rightOperation =  holder.findOperation(secondArg);
        Double leftArgument = leftOperation.execute();
        Double rightArgument = rightOperation.execute();
        return solve(leftArgument, rightArgument);
    }

    protected abstract Double solve(Double leftArgument, Double rightArgument);
}
