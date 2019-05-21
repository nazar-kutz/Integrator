package vn7.studio.com.integrator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import vn7.studio.com.integrator.keyboard.FunctionPreparator;
import vn7.studio.com.integrator.keyboard.InputKey;
import vn7.studio.com.integrator.math.calculator.MathCalcAlgorithm;

public class InputFunctionActivity extends AppCompatActivity {
    public final static int CALCULATOR_MODE = 0;
    public final static int FUNCTION_MODE = 1;
    public final static String MODE_TYPE = "mode_type";
    public final static String FUNCTION = "function";
    private int currentMode;

    private FrameLayout currentKeyboard;
    private FunctionPreparator functionPreparator;
    private FrameLayout btnNumbers, btnSpecial, btnTrigonometry, btnBackspace;

    private TextView tvInputDisplay;

    //Keyboard 1 : Numbers
    private ArrayList<FrameLayout> numberKeyboard;
    private FrameLayout btnEquals, btnConfirm;

    //Keyboard 2 : Special
    private ArrayList<FrameLayout> specialKeyboard;

    //Keyboard 3 : Trigonometry
    private ArrayList<FrameLayout> trigonometryKeyboard;

    /*//Keyboard 1 : Numbers
    private FrameLayout btnNumber7, btnNumber8, btnNumber9, btnPlus,
                        btnNumber4, btnNumber5, btnNumber6, btnMinus,
                        btnNumber1, btnNumber2, btnNumber3, btnMultiply,
                        btnDot,     btnNumber0, btnEquals,  btnDivide;

    //Keyboard 2 : Specials
    private FrameLayout btnArgument,    btnPower,        btnSqrt,
                        btnBracketOpen, btnBracketClose, btnFactorial;

    //Keyboard 3 : Trigonometry
    private FrameLayout btnSin,     btnCos,    btnTan,
                        btnASin,    btnACos,   btnATan,
                        btnCtan,    btnLn,     btnLg,
                        btnExp,     btnE,      btnPi;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_function);

        functionPreparator = FunctionPreparator.getInstance();

        btnNumbers = findViewById(R.id.btnNumbers);
        btnSpecial = findViewById(R.id.btnSpecial);
        btnTrigonometry = findViewById(R.id.btnTrigonometry);
        btnBackspace = findViewById(R.id.btnBackspace);

        InputFunctionActivity.AdditionalFunctionButtonListener listener =
                new InputFunctionActivity.AdditionalFunctionButtonListener();
        btnNumbers.setOnClickListener(listener);
        btnSpecial.setOnClickListener(listener);
        btnTrigonometry.setOnClickListener(listener);

        currentKeyboard = findViewById(R.id.flKeyboard);

        tvInputDisplay = findViewById(R.id.tvInputDisplay);

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                functionPreparator.removeLastInput();
                tvInputDisplay.setText(functionPreparator.getFunction());
            }
        });

        currentMode = getIntent().getExtras().getInt(MODE_TYPE);

        String function = getIntent().getExtras().getString(FUNCTION);
        if(function!=null && !function.equals("")){
            //todo parseFunction by functionPreparator
            functionPreparator.addElement(function);
            tvInputDisplay.setText(functionPreparator.getFunction());
        }

        initializeNumberKeyboard();
    }

    private class AdditionalFunctionButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnNumbers:
                    initializeNumberKeyboard();
                    break;
                case R.id.btnSpecial:
                    initializeSpecialKeyboard();
                    break;
                case R.id.btnTrigonometry:
                    initializeTrigonometryKeyboard();
                    break;
            }
        }
    }

    private class InputableButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            InputKey[] keys = InputKey.values();
            for (InputKey key : keys) {
                if (key.getId() == view.getId()) {
                    functionPreparator.addElement(key.getInput());

                    tvInputDisplay.setText(functionPreparator.getFunction());
                }
            }
        }
    }

    private void setNewKeyboard(int layoutId) {
        currentKeyboard.removeAllViews();
        View child = LayoutInflater.from(InputFunctionActivity.this).inflate(layoutId, null, false);
        currentKeyboard.addView(child);
    }

    private void initializeNumberKeyboard() {
        if (currentMode == CALCULATOR_MODE) {
            setNewKeyboard(R.layout.keyboard_standard_number_vertical_calculator);
        } else {
            setNewKeyboard(R.layout.keyboard_standard_number_vertical_function);
        }

        numberKeyboard = new ArrayList<>();
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber7));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber8));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber9));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnPlus));

        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber4));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber5));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber6));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnMinus));

        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber1));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber2));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber3));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnMultiply));

        numberKeyboard.add((FrameLayout) findViewById(R.id.btnDot));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnNumber0));
        numberKeyboard.add((FrameLayout) findViewById(R.id.btnDivide));

        setInputableKeyListener(numberKeyboard);

        if (currentMode == CALCULATOR_MODE) {
            btnEquals = findViewById(R.id.btnEquals);
            btnEquals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String function = functionPreparator.getFunction();
                    //todo make answer
                    if (!function.equals("")) {
                        double result = MathCalcAlgorithm.calculate(functionPreparator.getTmpFunction());
                        tvInputDisplay.setText(String.valueOf(result));
                    }
                }
            });
        } else if (currentMode == FUNCTION_MODE) {
            btnConfirm = findViewById(R.id.btnConfirm);
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //todo return input function
                }
            });
        }
    }

    private void initializeSpecialKeyboard() {
        if (currentMode == CALCULATOR_MODE) {
            setNewKeyboard(R.layout.keyboard_standard_specials_vertical_calculator);
        } else {
            setNewKeyboard(R.layout.keyboard_standard_specials_vertical_function);
        }

        specialKeyboard = new ArrayList<>();
        specialKeyboard.add((FrameLayout) findViewById(R.id.btnPower));
        specialKeyboard.add((FrameLayout) findViewById(R.id.btnSqrt));
        specialKeyboard.add((FrameLayout) findViewById(R.id.btnBracketOpen));
        specialKeyboard.add((FrameLayout) findViewById(R.id.btnBracketClose));
        specialKeyboard.add((FrameLayout) findViewById(R.id.btnFactorial));

        if (currentMode == FUNCTION_MODE) {
            specialKeyboard.add((FrameLayout) findViewById(R.id.btnArgument));
        }

        setInputableKeyListener(specialKeyboard);
    }

    private void initializeTrigonometryKeyboard() {
        setNewKeyboard(R.layout.keyboard_standard_trigonometry_vertical);

        trigonometryKeyboard = new ArrayList<>();
        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnSin));
        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnCos));
        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnTan));

        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnASin));
        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnAcos));
        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnAtan));

        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnCtan));
        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnLn));
        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnLg));

        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnExp));
        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnE));
        trigonometryKeyboard.add((FrameLayout) findViewById(R.id.btnPi));

        setInputableKeyListener(trigonometryKeyboard);
    }

    private void setInputableKeyListener(ArrayList<FrameLayout> inputableButtons) {
        InputFunctionActivity.InputableButtonListener listener = new InputFunctionActivity.InputableButtonListener();
        for (FrameLayout inputableButton : inputableButtons) {
            inputableButton.setOnClickListener(listener);
        }
    }
}
