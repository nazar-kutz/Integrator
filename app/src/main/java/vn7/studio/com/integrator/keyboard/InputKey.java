package vn7.studio.com.integrator.keyboard;

import vn7.studio.com.integrator.R;

public enum InputKey {
    NUMBER_NULL(R.id.btnNumber0, "0"),
    NUMBER_ONE(R.id.btnNumber1, "1"),
    NUMBER_TWO(R.id.btnNumber2, "2"),
    NUMBER_THREE(R.id.btnNumber3, "3"),
    NUMBER_FOUR(R.id.btnNumber4, "4"),
    NUMBER_FIVE(R.id.btnNumber5, "5"),
    NUMBER_SIX(R.id.btnNumber6, "6"),
    NUMBER_SEVEN(R.id.btnNumber7, "7"),
    NUMBER_EIGHT(R.id.btnNumber8, "8"),
    NUMBER_NINE(R.id.btnNumber9, "9"),

    SING_ARGUMENT(R.id.btnArgument, "x"),
    SING_BRACKET_OPEN(R.id.btnBracketOpen, "("),
    SING_BRACKET_CLOSE(R.id.btnBracketClose, ")"),
    SING_DOT(R.id.btnDot, "."),
    SING_E(R.id.btnE, "e"),
    SING_PI(R.id.btnPi, "pi"),

    OPERATION_PLUS(R.id.btnPlus, "+"),
    OPERATION_MINUS(R.id.btnMinus, "-"),
    OPERATION_DIVIDE(R.id.btnDivide, "/"),
    OPERATION_MULTIPLY(R.id.btnMultiply, "×"),
    OPERATION_POWER(R.id.btnPower, "^"),
    OPERATION_SQRT(R.id.btnSqrt, "sqrt("),
    OPERATION_FACTORIAL(R.id.btnFactorial, "fac("),

    TRIGONOMETRY_SIN(R.id.btnSin, "sin("),
    TRIGONOMETRY_COS(R.id.btnCos, "cos("),
    TRIGONOMETRY_TAN(R.id.btnTan, "tan("),
    TRIGONOMETRY_ASIN(R.id.btnASin, "asin("),
    TRIGONOMETRY_ACOS(R.id.btnAcos, "acos("),
    TRIGONOMETRY_ATAN(R.id.btnAtan, "atan("),
    TRIGONOMETRY_CTAN(R.id.btnCtan, "ctan("),
    TRIGONOMETRY_EXP(R.id.btnExp, "exp("),
    TRIGONOMETRY_LN(R.id.btnLn, "ln("),
    TRIGONOMETRY_LG(R.id.btnLg, "lg(");

    private int keyId;
    private String input;

    InputKey(int keyId, String input) {
        this.keyId = keyId;
        this.input = input;
    }

    public int getId() {
        return keyId;
    }

    public String getInput() {
        return input;
    }
}
