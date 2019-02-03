package vn7.studio.com.integrator.math.calculator.factory;

import vn7.studio.com.integrator.math.calculator.operation.CalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.binary.BinaryCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.UnaryCalcOperation;
import vn7.studio.com.integrator.math.operation.Operation;
import vn7.studio.com.integrator.math.operation.OperationMainType;
import vn7.studio.com.integrator.math.operation.OperationType;

public class CalcOperationFactory {
    private CalcOperationFactory(){}

    private static class InstanceHolder {
        private static final CalcOperationFactory INSTANCE = new CalcOperationFactory();
    }

    public static CalcOperationFactory getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public UnaryCalcOperation createUnaryOperation(OperationType type, String o) {
        if (type.getMainType() == OperationMainType.UNARY) {
            UnaryCalcOperation operation;
            for (OperationType currentType : OperationType.values()) {
                if (type == currentType) {
                    operation = (UnaryCalcOperation) createOperation(currentType.getOperationClass());
                    String argument = o.substring(o.indexOf('(') + 1, o.lastIndexOf(')'));
                    operation.setArgument(argument);
                    return operation;
                }
            }
        }
        throw new UnsupportedOperationException();
    }

    public BinaryCalcOperation createBinaryOperation(OperationType type, String o, int indexOfOperation) {
        if (type.getMainType() == OperationMainType.BINARY) {
            BinaryCalcOperation operation;
            for (OperationType currentType : OperationType.values()) {
                if (type == currentType) {
                    operation = (BinaryCalcOperation) createOperation(currentType.getOperationClass());
                    String leftArgument = o.substring(0, indexOfOperation);
                    String rightArgument = o.substring(indexOfOperation + 1);
                    operation.setFirstArg(leftArgument);
                    operation.setSecondArg(rightArgument);
                    return operation;
                }
            }
        }
        throw new UnsupportedOperationException();
    }

    private Operation createOperation(Class clazz) {
        try {
            return (CalcOperation) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException();
    }
}
