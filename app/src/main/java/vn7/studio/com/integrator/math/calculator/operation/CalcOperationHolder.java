package vn7.studio.com.integrator.math.calculator.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn7.studio.com.integrator.math.calculator.BracketParser;
import vn7.studio.com.integrator.math.calculator.OperationHolder;
import vn7.studio.com.integrator.math.calculator.factory.CalcOperationFactory;
import vn7.studio.com.integrator.math.calculator.operation.number.NumberCalcOperation;
import vn7.studio.com.integrator.math.operation.OperationMainType;
import vn7.studio.com.integrator.math.operation.OperationSign;
import vn7.studio.com.integrator.math.operation.OperationType;

import static vn7.studio.com.integrator.math.operation.OperationType.NUMBER;
import static vn7.studio.com.integrator.math.operation.OperationType.POWER;

public class CalcOperationHolder extends OperationHolder<CalcOperation> {
    private final static char beginLineSign = '^';
    private final static char endLineSign = '$';
    private Matcher matcher;
    private Pattern pattern;

    public CalcOperationHolder() {

    }

    @Override
    public CalcOperation findOperation(String argument) {
        CalcOperation resultOperation = null;
        CalcOperationFactory factory = CalcOperationFactory.getInstance();

        //parse 
        //is number only
        String regEx = new StringBuilder().append(beginLineSign).
                append(NUMBER.getRegEx()).append(endLineSign).toString();
        pattern = Pattern.compile(regEx);
        matcher = pattern.matcher(argument);
        if (matcher.find()) {
            resultOperation = new NumberCalcOperation();
            ((NumberCalcOperation) resultOperation).setArgument(argument);
            return resultOperation;
        }

        //unary operation only
        String currentOperation = null;
        OperationType currentOperationType = null;
        for (OperationType type : OperationType.values()) {
            if (type.getMainType() == OperationMainType.UNARY) {
                regEx = new StringBuilder().append(beginLineSign).append(type.getRegEx()).toString();
                pattern = Pattern.compile(regEx);
                matcher = pattern.matcher(argument);
                if (matcher.find()) {
                    currentOperation = matcher.group();
                    currentOperationType = type;
                    break;
                }
            }
        }
        if (currentOperation != null) {
            if (currentOperationType == OperationType.SEQUENCE) {
                currentOperation = currentOperation.replaceAll("\\(", "");
            }
            currentOperation = BracketParser.parseSubFunction(argument, currentOperation);
            if (currentOperation.length() == argument.length()) {
                resultOperation = factory.createUnaryOperation(currentOperationType, currentOperation);
                if (currentOperation.startsWith("-")) {
                    resultOperation.setSign(OperationSign.NEGATIVE);
                }
                return resultOperation;
            }
        } else {
            regEx = new StringBuilder().append(beginLineSign).append(NUMBER.getRegEx()).toString();
            pattern = Pattern.compile(regEx);
            matcher = pattern.matcher(argument);
            if (matcher.find()) {
                currentOperation = matcher.group();
            }
        }

        //binary operation
        int currentIndex = -1;
        int priorityIndex = currentIndex;
        //currentOperationType = OperationType.getBinaryOperationForSign(argument.charAt(currentIndex));
        String subFunction = argument;
        currentOperation = "";
        currentOperationType = POWER;
        while (currentIndex < argument.length()) {
            subFunction = argument.substring(++currentIndex);
            //parse unary
            for (OperationType type : OperationType.values()) {
                if (type.getMainType() == OperationMainType.UNARY || type.getMainType() == OperationMainType.NUMBER) {
                    regEx = new StringBuilder().append(beginLineSign).append(type.getRegEx()).toString();
                    pattern = Pattern.compile(regEx);
                    matcher = pattern.matcher(subFunction);
                    if (matcher.find()) {
                        currentOperation = matcher.group();
                        if (type.getMainType() == OperationMainType.UNARY) {
                            if (type == OperationType.SEQUENCE) {
                                currentOperation = currentOperation.replaceAll("\\(", "");
                            }
                            currentOperation = BracketParser.parseSubFunction(subFunction, currentOperation);
                        }
                        break;
                    }
                }
            }

            //parse binary
            currentIndex += currentOperation.length();
            if (currentIndex < argument.length()) {
                OperationType currentBinaryOperationType =
                        OperationType.getBinaryOperationForSign(argument.charAt(currentIndex));
                if (currentOperationType.getPriority() >= currentBinaryOperationType.getPriority()) {
                    currentOperationType = currentBinaryOperationType;
                    priorityIndex = currentIndex;
                }
            }
        }
        resultOperation = factory.createBinaryOperation(currentOperationType, argument, priorityIndex);
        return resultOperation;
    }

    private String parseUnaryOperation(String o) {
        return null;
    }

    private String parseBinaryOperation(String o) {
        return null;
    }

    private String parseUnaryOperationArgument(String o) {
        return o.substring(o.indexOf('('), o.lastIndexOf(')'));
    }
}
