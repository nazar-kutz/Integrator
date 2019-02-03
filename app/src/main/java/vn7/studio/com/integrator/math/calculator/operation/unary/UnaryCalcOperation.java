package vn7.studio.com.integrator.math.calculator.operation.unary;

import vn7.studio.com.integrator.math.calculator.operation.CalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.CalcOperationHolder;

public abstract class UnaryCalcOperation extends CalcOperation {
    private String argument;

    @Override
    public Double execute() {
        CalcOperationHolder holder = new CalcOperationHolder();
        CalcOperation operation = holder.findOperation(argument);
        Double result = operation.execute();
        return sign.getMultiplier()*solve(result);
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    protected abstract Double solve(Double argument);
}
