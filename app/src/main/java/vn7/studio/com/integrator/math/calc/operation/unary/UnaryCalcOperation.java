package vn7.studio.com.integrator.math.calc.operation.unary;

import vn7.studio.com.integrator.math.calc.OperationHolder;
import vn7.studio.com.integrator.math.calc.operation.CalcOperation;
import vn7.studio.com.integrator.math.calc.operation.CalcOperationHolder;
import vn7.studio.com.integrator.math.operation.Operation;

public abstract class UnaryCalcOperation extends CalcOperation {
    private String arg;

    @Override
    public Double execute() {
        CalcOperation operation = CalcOperationHolder.findOperation(arg);
        Double result = operation.execute();
        return solve(result);
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    protected abstract Double solve(Double arg);
}
