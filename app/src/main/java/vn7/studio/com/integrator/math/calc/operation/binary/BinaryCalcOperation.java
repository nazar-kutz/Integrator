package vn7.studio.com.integrator.math.calc.operation.binary;

import vn7.studio.com.integrator.math.calc.OperationHolder;
import vn7.studio.com.integrator.math.calc.operation.CalcOperation;
import vn7.studio.com.integrator.math.calc.operation.CalcOperationHolder;
import vn7.studio.com.integrator.math.operation.Operation;

public abstract class BinaryCalcOperation extends CalcOperation {
    private String firstArg;
    private String secondArg;

    @Override
    public Double execute() {
        CalcOperation o1 = CalcOperationHolder.findOperation(firstArg);
        CalcOperation o2 =  CalcOperationHolder.findOperation(secondArg);
        Double res1 = o1.execute();
        Double res2 = o2.execute();
        return solve(res1, res2);
    }

    protected abstract Double solve(Double arg1, Double arg2);
}
