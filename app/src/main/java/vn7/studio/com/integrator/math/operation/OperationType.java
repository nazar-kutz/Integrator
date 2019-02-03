package vn7.studio.com.integrator.math.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import vn7.studio.com.integrator.math.calculator.operation.binary.AddCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.binary.DivideCalcOperaion;
import vn7.studio.com.integrator.math.calculator.operation.binary.MinusCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.binary.MultiplyCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.binary.PowerCalcOpearation;
import vn7.studio.com.integrator.math.calculator.operation.number.NumberCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.AcosCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.AsinCalcOpearion;
import vn7.studio.com.integrator.math.calculator.operation.unary.AtanCalcOpeation;
import vn7.studio.com.integrator.math.calculator.operation.unary.CosCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.CtanCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.ExpCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.FactorialCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.LnCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.LogTenCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.SequenceCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.SinCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.SqrtCalcOperation;
import vn7.studio.com.integrator.math.calculator.operation.unary.TanCalcOperation;

public enum OperationType {
    //binary
    ADD(OperationMainType.BINARY, ".+\\+.+", "+", 0, AddCalcOperation.class),
    MINUS(OperationMainType.BINARY, ".+\\-.+", "-", 1, MinusCalcOperation.class),
    DIVIDE(OperationMainType.BINARY, ".+/.+", "/", 2, DivideCalcOperaion.class),
    MULTIPLY(OperationMainType.BINARY, ".+\\*.+", "*", 2, MultiplyCalcOperation.class),
    POWER(OperationMainType.BINARY, ".+\\^.+", "^", 3, PowerCalcOpearation.class),

    //unary
    ACOS(OperationMainType.UNARY, "-?acos", "cos", 4, AcosCalcOperation.class),
    ASIN(OperationMainType.UNARY, "-?asin", "sin", 4, AsinCalcOpearion.class),
    ATAN(OperationMainType.UNARY, "-?atan", "atan", 4, AtanCalcOpeation.class),
    COS(OperationMainType.UNARY, "-?cos", "cos", 4, CosCalcOperation.class),
    CTAN(OperationMainType.UNARY, "-?ctan", "ctan", 4, CtanCalcOperation.class),
    EXP(OperationMainType.UNARY, "-?exp", "exp", 4, ExpCalcOperation.class),
    FACTORIAL(OperationMainType.UNARY, "-?fac", "!", 5, FactorialCalcOperation.class),
    LN(OperationMainType.UNARY, "-?ln", "ln", 4, LnCalcOperation.class),
    LG(OperationMainType.UNARY, "-?lg", "lg", 4, LogTenCalcOperation.class),
    SIN(OperationMainType.UNARY, "-?sin", "sin", 4, SinCalcOperation.class),
    SQRT(OperationMainType.UNARY, "-?sqrt", "sqrt", 4, SqrtCalcOperation.class),
    TAN(OperationMainType.UNARY, "-?tan", "tan", 4, TanCalcOperation.class),
    SEQUENCE(OperationMainType.UNARY, "-?\\(", "()", 5, SequenceCalcOperation.class),

    //number
    NUMBER(OperationMainType.NUMBER, "-?[0-9]+(\\.?[0-9]+([eE]-?[0-9]+)?)?", "n", 0,
            NumberCalcOperation.class);

    OperationType(OperationMainType t, String regEx, String description, int priority, Class c) {
        this.mainType = t;
        this.regEx = regEx;
        this.description = description;
        this.priority = priority;
        this.c = c;
    }

    OperationMainType mainType;
    String regEx;
    String description;
    int priority;
    Class c;

    public OperationMainType getMainType() {
        return mainType;
    }

    public String getRegEx() {
        return regEx;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Class getOperationClass() {
        return c;
    }

    public static OperationType getBinaryOperationForSign(char c) {
        OperationType result;
        switch (c) {
            case '+':
                result = ADD;
                break;
            case '-':
                result = MINUS;
                break;
            case '*':
                result = MULTIPLY;
                break;
            case '/':
                result = DIVIDE;
                break;
            case '^':
                result = POWER;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return result;
    }
}
